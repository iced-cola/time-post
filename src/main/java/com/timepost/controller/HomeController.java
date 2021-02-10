package com.timepost.controller;

import com.timepost.config.RoleAuth;
import com.timepost.entity.ResponseEntity;
import com.timepost.utils.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  02-09-2021 21:19:12
 * @description :  controller
 * @since :  v1.0
 */
@RestController
@RequestMapping(value = {"/", "/home"})
public class HomeController {

    @GetMapping(value = {"/", "/home"})
    public ResponseEntity<String> home() {
        return ResultUtil.success();
    }

}
