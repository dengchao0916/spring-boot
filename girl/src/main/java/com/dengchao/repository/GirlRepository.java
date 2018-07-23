package com.dengchao.repository;

import com.dengchao.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author : Administrator
 * @Description :
 * @date : 上午 12:00  2018/7/23 0023
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    public List<Girl> findByAge(Integer age);
}
