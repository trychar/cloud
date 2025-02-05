package com.web.cloud.controller;

import com.web.cloud.dto.WrapperResponse;
import com.web.cloud.entities.Pay;
import com.web.cloud.entities.PayDTO;
import com.web.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController{
    @Resource
    PayService payService;
    @PostMapping(value = "/pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    public WrapperResponse<String> addPay(@RequestBody Pay pay){
        System.out.println(pay.toString());
        int i = payService.add(pay);
        return WrapperResponse.success("成功插入记录，返回值："+i);
    }
    @DeleteMapping(value = "/pay/del/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public WrapperResponse<Integer> deletePay(@PathVariable("id") Integer id) {
        return WrapperResponse.success(payService.delete(id));
    }
    @PutMapping(value = "/pay/update")
    @Operation(summary = "修改",description = "修改支付流水方法")
    public WrapperResponse<String> updatePay(@RequestBody PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);

        int i = payService.update(pay);
        return WrapperResponse.success("成功修改记录，返回值："+i);
    }
    @GetMapping(value = "/pay/get/{id}")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public WrapperResponse<Pay> getById(@PathVariable("id") Integer id){
        if (id < 0) throw new RuntimeException("ID不能为负数");
        return WrapperResponse.success(payService.getById(id));
    }

    @GetMapping(value = "/pay/getAll")
    @Operation(summary = "查询全部流水",description = "查询全部支付流水方法")
    public WrapperResponse<List<Pay>> getAll(){
        return WrapperResponse.success(payService.getAll());
    }
}

