package cn.skuu.controller;

import cn.skuu.pojo.vo.ReturnVO;
import cn.skuu.service.IQqaiCityService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 省市县详细 前端控制器
 * </p>
 *
 * @author dcx
 * @since 2025-05-25
 */
@RestController
@RequestMapping("/qqai-city")
public class QqaiCityController {

    @Autowired
    private IQqaiCityService iQqaiCityService;

    @ApiOperation(value = "更新城市编码")
    @PostMapping("/refreshAdCode")
    public ReturnVO<Boolean> refreshAdCode() {
        iQqaiCityService.refreshAdCode();
        return ReturnVO.ok();
    }
}
