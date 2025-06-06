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
import cn.skuu.util.IpUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.feiyizhan.idcard.IdCardInfo;
import io.github.feiyizhan.idcard.IdCardUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/api")
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

    @ApiOperation(value = "ip信息")
    @PostMapping("/ip")
    public ReturnVO<IpInfoDTO> ip(HttpServletRequest request, @RequestBody @Valid @NotBlank IpInfoDTO ipInfoDTO) {
        String ip = ipInfoDTO.getIp();
        if ("local".equalsIgnoreCase(ip)) {
            ip = IpUtils.getIpAddr(request);
        }
        IpInfoDTO ipInfo = ip2regionSearcher.getIpInfo(ip);
        if (ipInfo == null) {
            return ReturnVO.ok();
        }
        IpInfo info = ipInfoAdapter.ipInfoDTO2Entity(ipInfo);
        iIpInfoService.save(info);
        return ReturnVO.ok(ipInfo);
    }

    @ApiOperation(value = "id信息")
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
