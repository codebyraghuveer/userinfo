package com.tech.userinfo.service;

import com.tech.userinfo.dto.UserInfoDto;

import java.util.List;

public interface UserInfoService {

    UserInfoDto addUser(UserInfoDto userInfoDto);

    List<UserInfoDto> getUsers();

    UserInfoDto getUserById(Long id);
}
