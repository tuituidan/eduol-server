package com.edu.online.controller;

import com.edu.online.consts.Const;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * IndexController.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/1/30
 */
@RestController
@RequestMapping(Const.API_V1)
@Api(tags = "测试接口")
public class IndexController {

    /**
     * 测试接口.
     *
     * @return string
     */
    @ApiOperation("测试接口")
    @GetMapping("/ping")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("success");
    }
}
