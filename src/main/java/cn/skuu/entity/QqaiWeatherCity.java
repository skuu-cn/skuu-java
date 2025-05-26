package cn.skuu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author dcx
 * @since 2025-05-26
 */
@Getter
@Setter
@TableName("qqai_weather_city")
public class QqaiWeatherCity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

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
