package com.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：fei
 * @date ：Created in 2019/8/22 0022 16:03
 */
@RestController
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "welcome index !!!";
    }
}
