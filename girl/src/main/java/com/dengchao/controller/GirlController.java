package com.dengchao.controller;

import com.dengchao.entity.Girl;
import com.dengchao.entity.Result;
import com.dengchao.repository.GirlRepository;
import com.dengchao.service.GirlService;
import com.dengchao.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * @Author : Administrator
 * @Description :
 * @date : 上午 1:05  2018/7/23 0023
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> getList() {
        return girlRepository.findAll();
    }

    @PostMapping(value = "/girls")
    public Result<Girl> addGirl(@Validated Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());

        return ResultUtil.success(girlRepository.save(girl));
    }

    @GetMapping(value = "/girls/{id}")
    public Optional<Girl> findGirlById(@PathVariable("id") Integer id) {
        return girlRepository.findById(id);
    }

    //更新
    //x-www-form-urlencoded
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }

    //删除
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        Girl gir = new Girl();
        gir.setId(id);
        girlRepository.delete(gir);
    }

    //通过年龄查询女生列表
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }

    @GetMapping(value = "girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) {
        girlService.getAge(id);
    }

}
