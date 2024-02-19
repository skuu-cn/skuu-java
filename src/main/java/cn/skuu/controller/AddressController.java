package cn.skuu.controller;

import cn.skuu.config.Ip2regionSearcher;
import cn.skuu.pojo.dto.IdDto;
import cn.skuu.pojo.dto.IpInfoDTO;
import cn.skuu.pojo.vo.ReturnVO;
import io.github.feiyizhan.idcard.IdCardInfo;
import io.github.feiyizhan.idcard.IdCardUtils;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 地址查询 前端控制器
 * </p>
 *
 * @author dcx
 * @since 2024-02-07
 */
@Api(tags = "查询")
@RestController
@RequestMapping("/skuu/api")
public class AddressController {

    @Autowired
    private Ip2regionSearcher ip2regionSearcher;

    @Operation(summary = "地址信息")
    @PostMapping("/address")
    public ReturnVO<IpInfoDTO> address(@RequestBody @Valid @NotBlank IpInfoDTO ipInfoDTO) {
        String ip = ipInfoDTO.getIp();
        IpInfoDTO ipInfo = ip2regionSearcher.getIpInfo(ip);
        return ReturnVO.ok(ipInfo);
    }

    @Operation(summary = "id信息")
    @PostMapping("/id")
    public ReturnVO<IdCardInfo> id(@RequestBody @Valid @NotBlank IdDto idDto) {
        IdCardInfo idCardInfo = IdCardUtils.getIdCardInfo(idDto.getId());
        return ReturnVO.ok(idCardInfo);
    }
}
