package cn.skuu.pojo.dto;

import lombok.Data;

/**
 *
 * @author dcx
 * @since 2024-02-07 23:00
 **/
@Data
public class DayHotDto {
    private Integer status;
    private Boolean error;
    private DayHotData data;
}
