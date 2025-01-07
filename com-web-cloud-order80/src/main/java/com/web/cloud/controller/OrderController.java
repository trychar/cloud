package com.web.cloud.controller;

import com.web.cloud.dto.WrapperResponse;
import com.web.cloud.entities.Pay;
import com.web.cloud.entities.PayDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Tag(name = "订单微服务模块",description = "订单CRUD")
public class OrderController {
    @Resource
    RestTemplate restTemplate;

    private static String PAY_URL = "http://localhost:8001";

    @PostMapping(value = "/order/add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    public WrapperResponse<String> addPay(@RequestBody Pay pay){
        System.out.println(pay.toString());
        return restTemplate.postForObject(PAY_URL+"/pay/add",pay, WrapperResponse.class);
    }
    @DeleteMapping(value = "/order/del/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public WrapperResponse<Integer> deletePay(@PathVariable("id") Integer id) {
        return restTemplate.postForObject(PAY_URL+"/pay/del/"+id,id, WrapperResponse.class);
    }
    @PutMapping(value = "/order/update")
    @Operation(summary = "修改",description = "修改支付流水方法")
    public WrapperResponse<String> updatePay(@RequestBody PayDTO payDTO){
        return  restTemplate.postForObject(PAY_URL+"/pay/update",payDTO, WrapperResponse.class);
    }
    @GetMapping(value = "/order/get/{id}")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public WrapperResponse<Pay> getById(@PathVariable("id") Integer id){
        if (id < 0) throw new RuntimeException("ID不能为负数");
        return restTemplate.getForObject(PAY_URL+"/pay/get/"+id,WrapperResponse.class,id);
    }

    @GetMapping(value = "/order/getAll")
    @Operation(summary = "查询全部流水",description = "查询全部支付流水方法")
    public WrapperResponse<List<Pay>> getAll(){
        return  restTemplate.getForObject(PAY_URL+"/pay/getAll", WrapperResponse.class);
    }
}

