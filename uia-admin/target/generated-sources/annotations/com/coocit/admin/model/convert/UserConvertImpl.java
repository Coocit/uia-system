package com.coocit.admin.model.convert;

import com.coocit.admin.model.dto.UserForm;
import com.coocit.admin.model.entity.User;
import com.coocit.admin.model.vo.UserVo;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-26T15:15:41+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class UserConvertImpl implements UserConvert {

    private final DateTimeFormatter dateTimeFormatter_yyyy_MM_dd_HH_mm_ss_11333195168 = DateTimeFormatter.ofPattern( "yyyy-MM-dd HH:mm:ss" );

    @Override
    public UserVo toVO(User user) {
        if ( user == null ) {
            return null;
        }

        UserVo userVo = new UserVo();

        if ( user.getCreateTime() != null ) {
            userVo.setCreateTime( dateTimeFormatter_yyyy_MM_dd_HH_mm_ss_11333195168.format( user.getCreateTime() ) );
        }
        userVo.setId( user.getId() );
        userVo.setName( user.getName() );
        userVo.setGender( user.getGender() );
        userVo.setEmail( user.getEmail() );
        userVo.setMobile( user.getMobile() );
        userVo.setAvatar( user.getAvatar() );
        userVo.setStatus( user.getStatus() );

        return userVo;
    }

    @Override
    public User toEntity(UserForm userForm) {
        if ( userForm == null ) {
            return null;
        }

        User user = new User();

        user.setId( userForm.getId() );
        user.setName( userForm.getName() );
        user.setGender( userForm.getGender() );
        user.setEmail( userForm.getEmail() );
        user.setMobile( userForm.getMobile() );
        user.setAvatar( userForm.getAvatar() );
        user.setStatus( userForm.getStatus() );

        return user;
    }

    @Override
    public UserForm toForm(User user) {
        if ( user == null ) {
            return null;
        }

        UserForm userForm = new UserForm();

        userForm.setId( user.getId() );
        userForm.setName( user.getName() );
        userForm.setGender( user.getGender() );
        userForm.setEmail( user.getEmail() );
        userForm.setMobile( user.getMobile() );
        userForm.setAvatar( user.getAvatar() );
        userForm.setStatus( user.getStatus() );

        return userForm;
    }
}
