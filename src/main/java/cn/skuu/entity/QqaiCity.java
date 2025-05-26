package cn.skuu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 省市县详细
 * </p>
 *
 * @author dcx
 * @since 2025-05-25
 */
@Getter
@Setter
@TableName("qqai_city")
public class QqaiCity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父id
     */
    private Integer pid;

    /**
     * 地区编码
     */
    private Integer adCode;

    /**
     * 简称
     */
    private String shortname;

    /**
     * 名称
     */
    private String name;

    /**
     * 全称
     */
    private String mergerName;

    /**
     * 层级 0 1 2 省市区县
     */
    private Integer level;

    /**
     * 拼音
     */
    private String pinyin;

    /**
     * 长途区号
     */
    private String code;

    /**
     * 邮编
     */
    private String zipCode;

    /**
     * 首字母
     */
    private String first;

    /**
     * 经度
     */
    private String lon;

    /**
     * 纬度
     */
    private String lat;
}
