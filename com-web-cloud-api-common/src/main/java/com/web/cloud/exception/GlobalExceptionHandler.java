package com.web.cloud.exception;

import com.web.cloud.dto.WrapperResponse;
import com.web.cloud.enums.ReturnCodeEnum;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
//全局异常处理注解，是全局异常处理注解@ControllerAdvice和@ResponseBody的组合
@RestControllerAdvice
public class GlobalExceptionHandler {
    //使用@ExceptionHandler来规定拦截的异常类型
    @ExceptionHandler(value = RuntimeException.class)
    //使用@ResponseStatus改变返回的http码值
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public WrapperResponse handleException(HttpServletRequest request,Exception e) {
        log.info("发生异常，请求地址:{},异常原因:{}",request.getRequestURL(),e.getMessage());
        return WrapperResponse.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
    }
}
