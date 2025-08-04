package cn.skuu.controller.api;

import cn.skuu.entity.DayHistoryDO;
import cn.skuu.pojo.dto.DayHistoryItemDTO;
import cn.skuu.pojo.vo.DayHistoryVo;
import cn.skuu.pojo.vo.ReturnVO;
import cn.skuu.service.IDayHistoryService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * <p>
 * 历史上的今天 前端控制器
 * </p>
 *
 * @author dcx
 * @since 2024-02-07
 */
@Api(tags = "历史上的今天")
@RestController
@RequestMapping("/api/dayHistory")
public class DayHistoryController {

    @Autowired
    private IDayHistoryService iDayHistoryService;

    @Autowired
    private ObjectMapper objectMapper;

    @ApiOperation(value = "历史上的今天")
    @GetMapping("/news")
    public ReturnVO<DayHistoryVo> getDayHistory(@RequestParam @Valid @NotBlank String day) throws IOException {
        DayHistoryDO dayHistoryDO = iDayHistoryService.getByDay(day);
        if (dayHistoryDO == null) {
            return ReturnVO.ok();
        }
        DayHistoryVo dayHotVo = new DayHistoryVo()
                .setDate(dayHistoryDO.getDate())
                .setCreateTime(dayHistoryDO.getCreateTime())
                .setItems(objectMapper.readValue(dayHistoryDO.getContent().getBytes(), new TypeReference<List<DayHistoryItemDTO>>() {
                    @Override
                    public Type getType() {
                        return super.getType();
                    }
                }));
        return ReturnVO.ok(dayHotVo);
    }
}
