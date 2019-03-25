package me.xueyao.controller;

import me.xueyao.common.BaseResponse;
import me.xueyao.config.WeiXinConfig;
import me.xueyao.constant.ResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Simon.Xue
 * @date: 2019/3/25 17:35
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    private final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private WeiXinConfig weiXinConfig;


}
