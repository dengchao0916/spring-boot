package com.dengchao.exception;

import com.dengchao.enums.ResultEnum;

/**
 * @Author : Administrator
 * @Description :
 * @date : 下午 6:58  2018/7/23 0023
 */
public class GirlException extends RuntimeException {
    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
