package cn.skuu.controller.api;

import cn.skuu.entity.DayHotDO;
import cn.skuu.pojo.dto.DayHotItemDTO;
import cn.skuu.pojo.vo.DayHotVo;
import cn.skuu.pojo.vo.ReturnVO;
import cn.skuu.service.IDayHotService;
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
 * 每日热点 前端控制器
 * </p>
 *
 * @author dcx
 * @since 2024-02-07
 */
@Api(tags = "每日热点")
@RestController
@RequestMapping("/api/dayHot")
public class DayHotController {

    @Autowired
    private IDayHotService iDayHotService;

    @Autowired
    private ObjectMapper objectMapper;

    @ApiOperation(value = "每日热点")
    @GetMapping("/news")
    public ReturnVO<DayHotVo> getDayHot(@RequestParam @Valid @NotBlank String date) throws IOException {
        DayHotDO dayHotDO = iDayHotService.getByDay(date);
        if (dayHotDO == null) {
            return ReturnVO.ok();
        }
        DayHotVo dayHotVo = new DayHotVo()
                .setDate(dayHotDO.getDate())
                .setCreateTime(dayHotDO.getCreateTime())
                .setItems(objectMapper.readValue(dayHotDO.getContent().getBytes(), new TypeReference<List<DayHotItemDTO>>() {
                    @Override
                    public Type getType() {
                        return super.getType();
                    }
                }));
        return ReturnVO.ok(dayHotVo);
    }
}
