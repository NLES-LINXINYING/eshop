package com.example.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SendController.java
 * @Description TODO
 * @createTime 2021-05-25 16:04:00
 */
@Controller
public class SendController {

    @RequestMapping("/send/{path}/{filename}")
    public String send(@PathVariable String path, @PathVariable String filename) {
        System.out.println(path + "," + filename);
        return "/" + path + "/" + filename;
    }
}
