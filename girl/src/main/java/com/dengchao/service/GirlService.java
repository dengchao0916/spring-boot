package com.dengchao.service;

import com.dengchao.entity.Girl;
import com.dengchao.enums.ResultEnum;
import com.dengchao.exception.GirlException;
import com.dengchao.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Author : Administrator
 * @Description :
 * @date : 上午 1:05  2018/7/23 0023
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);


        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setAge(19);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) {
        Girl girl = girlRepository.getOne(id);
        Integer age = girl.getAge();
        if(age < 10){
            throw  new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age > 10 && age < 16){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }else{

        }
    }
}
