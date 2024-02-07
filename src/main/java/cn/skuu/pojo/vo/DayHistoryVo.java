package cn.skuu.pojo.vo;

import cn.skuu.pojo.dto.DayHistoryItem;
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
public class DayHistoryVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 时间
     */
    private String date;

    /**
     * 内容
     */
    private List<DayHistoryItem> items;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
