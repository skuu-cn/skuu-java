package cn.skuu.pojo.dto;

import lombok.Data;

import java.util.List;

/**
 *
 * @author dcx
 * @since 2024-02-07 23:00
 **/
@Data
public class DayHistoryDataDTO {
    private String day;
    private String soul;
    private List<DayHistoryItemDTO> today_in_history;
}
