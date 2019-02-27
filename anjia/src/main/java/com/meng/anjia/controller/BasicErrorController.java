package com.meng.anjia.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yue on 2019/2/27
 */
public class BasicErrorController implements ErrorController {

    @Override
    @RequestMapping("/error")
    public String getErrorPath() {
        return "error";
    }
}
