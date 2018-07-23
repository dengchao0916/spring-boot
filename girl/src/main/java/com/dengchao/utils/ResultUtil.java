package com.dengchao.utils;

import com.dengchao.entity.Result;

/**
 * @Author : Administrator
 * @Description :
 * @date : 下午 6:26  2018/7/23 0023
 */
public class ResultUtil {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("Success");
        result.setData(object);
        return result;
    }

    public static Result success() {


        return success(null);

    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
