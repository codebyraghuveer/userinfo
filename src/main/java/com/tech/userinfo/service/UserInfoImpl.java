package com.tech.userinfo.service;

import com.tech.userinfo.dto.UserInfoDto;
import com.tech.userinfo.entity.UserInfo;
import com.tech.userinfo.mapper.UserInfoMapper;
import com.tech.userinfo.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserInfoImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfoDto addUser(UserInfoDto userInfoDto) {
        UserInfo savedUserInfo = userInfoRepository.save(UserInfoMapper.INSTANCE.mapToUserInfo(userInfoDto));
        return UserInfoMapper.INSTANCE.mapTOUserInfoDto(savedUserInfo);
    }

    @Override
    public List<UserInfoDto> getUsers() {

        List<UserInfo> userInfoList = userInfoRepository.findAll();
        return userInfoList.stream()
                .map(userInfo -> UserInfoMapper.INSTANCE.mapTOUserInfoDto(userInfo))
                .collect(Collectors.toList());

    }

    @Override
    public UserInfoDto getUserById(Long id) {
        Optional<UserInfo> userInfoOptional = userInfoRepository.findById(id);
        if (userInfoOptional.isPresent()) {
            return UserInfoMapper.INSTANCE.mapTOUserInfoDto(userInfoOptional.get());
        }
        return null;
    }
}
