package cn.skuu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 博客
 * </p>
 *
 * @author dcx
 * @since 2025-06-07
 */
@Getter
@Setter
@TableName("skuu_blog")
@ApiModel(value = "SkuuBlog对象", description = "博客")
public class SkuuBlog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("广场id")
    private Long squareId;

    @ApiModelProperty("话题id")
    private String topicIds;

    @ApiModelProperty("分类，1:普通，2:求助，3:助力")
    private Byte categary;

    @ApiModelProperty("类型，1:图文，2:视频")
    private Byte blogType;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("资源列表")
    private String resources;

    @ApiModelProperty("地区")
    private Integer addressId;

    @ApiModelProperty("共享类型。1:公开，2:私密，3:仅朋友可看")
    private Byte shareType;

    @ApiModelProperty("用户id")
    private String creator;

    @ApiModelProperty("更新人")
    private String updater;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("是否删除，0:未删除，1:删除")
    private Boolean deleted;
}
