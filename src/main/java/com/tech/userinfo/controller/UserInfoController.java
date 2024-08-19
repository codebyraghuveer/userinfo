package com.tech.userinfo.controller;

import com.tech.userinfo.dto.UserInfoDto;
import com.tech.userinfo.service.UserInfoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@CrossOrigin("*")
public class UserInfoController {


    private UserInfoService userInfoService;

    @PostMapping("/addUser")
    public ResponseEntity<UserInfoDto> addUser(@RequestBody UserInfoDto userInfoDto) {
        UserInfoDto addedUserDto = userInfoService.addUser(userInfoDto);
        return new ResponseEntity<>(addedUserDto, HttpStatus.CREATED);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<UserInfoDto>> fetchUsers() {
        List<UserInfoDto> userInfoDtoList = userInfoService.getUsers();
        return new ResponseEntity<>(userInfoDtoList, HttpStatus.OK);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserInfoDto> getUserById(@PathVariable Long id) {
        UserInfoDto userInfoDto = userInfoService.getUserById(id);
        if (userInfoDto != null)
            return new ResponseEntity<>(userInfoDto, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


}
