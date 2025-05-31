package cn.skuu.pojo.dto;

import cn.skuu.common.enums.CommonResponseEnum;
import lombok.Data;

/**
 *
 * @author dcx
 * @since 2025-05-30 21:35
 **/
@Data
public class GPSDto {
    /**
     * lat，纬度
     */
    private String lat;

    /**
     * lon，经度
     */
    private String lon;
    private CommonResponseEnum commonResponseEnum = CommonResponseEnum.SUCCESS;

}
