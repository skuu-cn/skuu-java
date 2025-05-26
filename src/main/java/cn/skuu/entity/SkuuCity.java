package cn.skuu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 省市县
 * </p>
 *
 * @author dcx
 * @since 2025-05-25
 */
@Getter
@Setter
@TableName("skuu_city")
public class SkuuCity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 地区编码
     */
    private Integer id;

    /**
     * 地区名称
     */
    private String name;

    /**
     * 地区类型：1:国家，2:省/直辖市/自治区，3:市，4:区县
     */
    private Integer type;

    /**
     * 父级地区编码
     */
    private Integer parentId;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 更新人
     */
    private String updater;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    private Boolean deleted;
}
