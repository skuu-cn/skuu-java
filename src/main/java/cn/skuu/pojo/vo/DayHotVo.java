package cn.skuu.pojo.vo;

import cn.skuu.pojo.dto.DayHotItemDTO;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 每日热点
 * </p>
 *
 * @author dcx
 * @since 2024-02-07
 */
@Data
public class DayHotVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 时间
     */
    private String date;

    /**
     * 内容
     */
    private List<DayHotItemDTO> items;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
