package cn.skuu.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author dcx
 * @since 2025-05-31
 */
@Data
public class WeatherUserCityVo {

    private Integer id;

    private Integer userId;

    private Integer cityId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    /**
     * 地区编码
     */
    private Integer adCode;

    /**
     * 省份中文名称
     */
    private String province;

    /**
     * 省份拼音
     */
    private String provincePinyin;

    /**
     * 市中文名称
     */
    private String city;

    /**
     * 市拼音
     */
    private String cityPinyin;

    /**
     * 区县
     */
    private String county;

    /**
     * 区县拼音
     */
    private String countyPinyin;

    /**
     * lat，纬度
     */
    private String lat;

    /**
     * lon，经度
     */
    private String lon;
}
