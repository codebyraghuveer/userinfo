package com.tech.userinfo.mapper;

import com.tech.userinfo.dto.UserInfoDto;
import com.tech.userinfo.entity.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserInfoMapper {
    UserInfoMapper INSTANCE = Mappers.getMapper(UserInfoMapper.class);

    UserInfo mapToUserInfo(UserInfoDto userInfoDto);

    UserInfoDto mapTOUserInfoDto(UserInfo userInfo);

}
