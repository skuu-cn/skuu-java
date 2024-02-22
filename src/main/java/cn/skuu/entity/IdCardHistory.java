package cn.skuu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author dcx
 * @since 2024-02-21
 */
@Getter
@Setter
@TableName("id_card_history")
public class IdCardHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 身份证号码
     */
    private String idCard;

    /**
     * 身份证号码信息
     */
    private String idCardInfo;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
