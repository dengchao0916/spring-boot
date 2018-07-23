package com.dengchao.controller;

import com.dengchao.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : Administrator
 * @Description :
 * @date : 下午 4:48  2018/7/21 0021
 */
@RestController
@RequestMapping("/say")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    //http://127.0.0.1:8081/girl/say/hello/23
    @RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
    public String say(@PathVariable Integer id) {
        return girlProperties.getCupSize() + id;
    }

    //http://127.0.0.1:8081/girl/say/hi?id=23
    //@RequestMapping(value = "/hi", method = RequestMethod.GET)
    @GetMapping(value = "/hi")
    public String hi(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id) {
        return girlProperties.getCupSize() + id;
    }
}
