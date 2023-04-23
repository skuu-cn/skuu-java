package cn.skuu.skuuserver.controller;

import cn.skuu.framework.common.pojo.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cn.skuu.framework.common.exception.enums.GlobalErrorCodeConstants.NOT_IMPLEMENTED;


/**
 * 默认 Controller，解决部分 module 未开启时的 404 提示。
 * 例如说，/bpm/** 路径，工作流
 *
 * @author 芋道源码
 */
@RestController
public class DefaultController {

    @RequestMapping("/admin-api/bpm/**")
    public CommonResult<Boolean> bpm404() {
        return CommonResult.error(NOT_IMPLEMENTED.getCode(),
                "[工作流模块 yudao-module-bpm - 已禁用][参考 https://doc.iocoder.cn/bpm/ 开启]");
    }

//    @RequestMapping("/admin-cn.skuu.userservice.api/mp/**")
//    public CommonResult<Boolean> mp404() {
//        return CommonResult.error(NOT_IMPLEMENTED.getCode(),
//                "[微信公众号 yudao-module-mp - 已禁用][参考 https://doc.iocoder.cn/mp/build/ 开启]");
//    }
//
//    @RequestMapping(value = {"/admin-cn.skuu.userservice.api/product/**", // 商品中心
//            "/admin-cn.skuu.userservice.api/trade/**", // 交易中心
//            "/admin-cn.skuu.userservice.api/promotion/**"})  // 营销中心
//    public CommonResult<Boolean> mall404() {
//        return CommonResult.error(NOT_IMPLEMENTED.getCode(),
//                "[商城系统 yudao-module-mall - 已禁用][参考 https://doc.iocoder.cn/mall/build/ 开启]");
//    }
//
//    @RequestMapping(value = {"/admin-cn.skuu.userservice.api/report/**"})
//    public CommonResult<Boolean> report404() {
//        return CommonResult.error(NOT_IMPLEMENTED.getCode(),
//                "[报表模块 yudao-module-report - 已禁用][参考 https://doc.iocoder.cn/report/ 开启]");
//    }

}
