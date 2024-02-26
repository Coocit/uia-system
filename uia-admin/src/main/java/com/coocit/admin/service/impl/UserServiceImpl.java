package com.coocit.admin.service.impl;

import cn.hutool.core.text.CharSequenceUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coocit.admin.model.convert.UserConvert;
import com.coocit.admin.model.dto.UserDTO;
import com.coocit.admin.model.dto.UserForm;
import com.coocit.admin.model.entity.Organization;
import com.coocit.admin.model.entity.User;
import com.coocit.admin.model.entity.UserOrg;
import com.coocit.admin.model.vo.UserInfoVo;
import com.coocit.admin.model.vo.UserVo;
import com.coocit.admin.repository.OrganizationRepository;
import com.coocit.admin.repository.UserOrgRepository;
import com.coocit.admin.repository.UserRepository;
import com.coocit.admin.service.UserService;
import com.coocit.common.response.PageResult;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.ListUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: Coocit
 * @date: 2024/1/19
 * @description:
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserRepository, User> implements UserService {

    private final UserConvert userConvert;

    @Resource
    private UserOrgRepository userOrgRepository;

    @Resource
    private OrganizationRepository organizationRepository;

    @Override
    public UserInfoVo getUserInfo() {
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setUserId(1000L);
        userInfoVo.setNickname("Coocit");
        userInfoVo.setAvatar("null");
        Set<String> roles = new HashSet<>();
        roles.add("ROOT");
        userInfoVo.setRoles(roles);
        HashSet<String> perms = new HashSet<>();
        userInfoVo.setPerms(perms);
        return userInfoVo;
    }

    @Override
    public PageResult<UserVo> findUserPage(UserDTO userDTO) {
        //user中包含 组织 返回组织名称
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery();
        Page<User> userPage = new Page<>(userDTO.getPageNum(),userDTO.getPageSize());
        if (CharSequenceUtil.isNotBlank(userDTO.getKeywords())){
            queryWrapper.
                    like(User::getName,userDTO.getKeywords()).
                    or().
                    like(User::getMobile,userDTO.getKeywords());
        }
        if (userDTO.getStatus() != null){
            queryWrapper.eq(User::getStatus,userDTO.getStatus());
        }
        Page<User> page = this.page(userPage, queryWrapper);
        List<User> records = page.getRecords();
        if (records.isEmpty()){
            return PageResult.empty();
        }
        //用户关联的组织列表
        List<Long> userIdList = records.stream().map(User::getId).toList();
        LambdaQueryWrapper<UserOrg> userOrgQuery = Wrappers.lambdaQuery();
        userOrgQuery.in(UserOrg::getUserId, userIdList);
        List<UserOrg> userOrgList = userOrgRepository.selectList(userOrgQuery);
        List<Long> orgIdList = userOrgList.stream().map(UserOrg::getOrgId).toList();
        //userOrgList userId - List<orgId>
        Map<Long, List<Long>> userOrgMap = userOrgList.stream().collect(Collectors.groupingBy(UserOrg::getUserId, Collectors.mapping(UserOrg::getOrgId, Collectors.toList())));
        //根据组织id 查询组织信息
        LambdaQueryWrapper<Organization> orgQuery = Wrappers.lambdaQuery();
        orgQuery.in(Organization::getId,orgIdList);
        List<Organization> organizationList = organizationRepository.selectList(orgQuery);
        //组合数据
        List<UserVo> userVoList = new ArrayList<>();
        for (User user : records) {
            List<Organization> userOrganizationList = ListUtils.select(organizationList, o -> ListUtils.emptyIfNull(userOrgMap.get(user.getId())).contains(o.getId()));
            UserVo userVO = userConvert.toVO(user);
            List<String> nameList = userOrganizationList.stream().map(Organization::getName).toList();
            userVO.setOrgNames(nameList);
            userVoList.add(userVO);
        }
        return PageResult.of(userVoList, (int) page.getTotal(),userDTO.getPageNum(),userDTO.getPageSize());
    }

    @Transactional
    @Override
    public Long add(UserForm userForm) {
        User user = userConvert.toEntity(userForm);
        // TODO 默认头像以及默认密码加密
        user.setAvatar("https://img0.baidu.com/it/u=2416850868,2392496129&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1693501200&t=722ff48c198154281bb273e2cdf919d9");
        user.setPassword("123456");
        this.save(user);
        for (Long orgId : userForm.getOrgIds()) {
            UserOrg userOrg = UserOrg.builder().userId(user.getId()).orgId(orgId).build();
            this.userOrgRepository.insert(userOrg);
        }
        return user.getId();
    }

    @Override
    public UserForm findUserById(Long id) {
        User user = this.getById(id);
        LambdaQueryWrapper<UserOrg> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(UserOrg::getUserId,user.getId());
        List<UserOrg> userOrgs = this.userOrgRepository.selectList(queryWrapper);
        List<Long> orgIds = userOrgs.stream().map(UserOrg::getOrgId).toList();
        UserForm userForm = userConvert.toForm(user);
        userForm.setOrgIds(orgIds);
        return userForm;
    }

    @Transactional
    @Override
    public Long modifyUserById(Long id, UserForm userForm) {
        User user = userConvert.toEntity(userForm);
        user.setId(id);
        this.updateById(user);
        LambdaQueryWrapper<UserOrg> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(UserOrg::getUserId,id);
        this.userOrgRepository.delete(queryWrapper);
        for (Long orgId : userForm.getOrgIds()) {
            UserOrg userOrg = UserOrg.builder().userId(user.getId()).orgId(orgId).build();
            this.userOrgRepository.insert(userOrg);
        }
        return id;
    }


}
