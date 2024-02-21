package cn.skuu.controller;

import cn.skuu.adapter.IpInfoAdapter;
import cn.skuu.config.Ip2regionSearcher;
import cn.skuu.entity.IdCardHistory;
import cn.skuu.entity.IpInfo;
import cn.skuu.pojo.dto.IdDto;
import cn.skuu.pojo.dto.IpInfoDTO;
import cn.skuu.pojo.vo.ReturnVO;
import cn.skuu.service.IIdCardHistoryService;
import cn.skuu.service.IIpInfoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Autowired
    private IIdCardHistoryService iIdCardHistoryService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private IpInfoAdapter ipInfoAdapter;

    @Autowired
    private IIpInfoService iIpInfoService;

    @Operation(summary = "ip信息")
    @PostMapping("/ip")
    public ReturnVO<IpInfoDTO> ip(@RequestBody @Valid @NotBlank IpInfoDTO ipInfoDTO) {
        String ip = ipInfoDTO.getIp();
        IpInfoDTO ipInfo = ip2regionSearcher.getIpInfo(ip);
        IpInfo info = ipInfoAdapter.ipInfoDTO2Entity(ipInfo);
        iIpInfoService.save(info);
        return ReturnVO.ok(ipInfo);
    }

    @Operation(summary = "id信息")
    @PostMapping("/id")
    public ReturnVO<IdCardInfo> id(@RequestBody @Valid @NotBlank IdDto idDto) throws JsonProcessingException {
        IdCardInfo idCardInfo = IdCardUtils.getIdCardInfo(idDto.getId());
        IdCardHistory idCardHistory = new IdCardHistory()
                .setIdCard(idDto.getId())
                .setIdCardInfo(objectMapper.writeValueAsString(idCardInfo));
        iIdCardHistoryService.save(idCardHistory);
        return ReturnVO.ok(idCardInfo);
    }
}
