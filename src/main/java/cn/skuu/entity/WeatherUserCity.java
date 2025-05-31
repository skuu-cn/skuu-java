package cn.skuu.entity;

import cn.skuu.common.enums.CommonResponseEnum;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author dcx
 * @since 2025-05-31
 */
@Getter
@Setter
@TableName("weather_user_city")
public class WeatherUserCity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private Integer cityId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
