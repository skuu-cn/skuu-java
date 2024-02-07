package cn.skuu.pojo.dto;

import lombok.Data;

import java.util.List;

/**
 *
 * @author dcx
 * @since 2024-02-07 23:00
 **/
@Data
public class DayHotData {
    private Integer status;
    private String day;
    private Integer limit;
    private String filter;
    private List<DayHotItem> items;
}
