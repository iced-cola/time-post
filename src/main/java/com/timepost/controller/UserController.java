package com.timepost.controller;

import com.timepost.entity.ResponseEntity;
import com.timepost.entity.UserEntity;
import com.timepost.entity.dto.UserDto;
import com.timepost.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-10-2021 17:22:31
 * @description :  用户业务接口
 * @since :  v1.0
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/create")
    public ResponseEntity<String> create(@RequestBody UserEntity userEntity) {
        return userService.createUser(userEntity);
    }

    @RequestMapping(value = "/delete")
    public ResponseEntity<Object> delete(@RequestParam String userId) {
        return userService.deleteUser(userId);
    }

    @RequestMapping(value = "/password/change")
    public ResponseEntity<Object> changePassword(@RequestParam UserDto userDto) {
        return userService.changePassword(userDto);
    }
}
