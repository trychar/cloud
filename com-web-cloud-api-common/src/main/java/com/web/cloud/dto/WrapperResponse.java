package com.web.cloud.dto;

import com.web.cloud.enums.ReturnCodeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class WrapperResponse<T> {

    private String code;/** 结果状态 ,具体状态码参见枚举类ReturnCodeEnum.java*/
    private String message;
    private T data;
    private long timestamp ;


    public WrapperResponse(){
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> WrapperResponse<T> success(T data) {
        WrapperResponse<T> WrapperResponse = new WrapperResponse<>();
        WrapperResponse.setCode(ReturnCodeEnum.RC200.getCode());
        WrapperResponse.setMessage(ReturnCodeEnum.RC200.getMessage());
        WrapperResponse.setData(data);
        return WrapperResponse;
    }

    public static <T> WrapperResponse<T> success(T data,String message) {
        WrapperResponse<T> WrapperResponse = new WrapperResponse<>();
        WrapperResponse.setCode(ReturnCodeEnum.RC200.getCode());
        WrapperResponse.setMessage(message);
        WrapperResponse.setData(data);
        return WrapperResponse;
    }

    public static <T> WrapperResponse<T> fail(String code, String message) {
        WrapperResponse<T> WrapperResponse = new WrapperResponse<>();
        WrapperResponse.setCode(code);
        WrapperResponse.setMessage(message);

        return WrapperResponse;
    }

}

