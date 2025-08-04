package cn.skuu.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 博客
 * </p>
 *
 * @author dcx
 * @since 2025-06-07
 */
@Data
@ApiModel(value = "SkuuBlog对象", description = "博客")
public class SkuuBlogAddDto {

    @ApiModelProperty("广场id")
    private Long squareId;

    @ApiModelProperty("话题id")
    private String topicIds;

    @ApiModelProperty("分类，1:普通，2:求助，3:助力")
    private Integer categary;

    @ApiModelProperty("类型，1:图文，2:视频")
    private Integer blogType;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("资源列表")
    private String resources;

    @ApiModelProperty("地区")
    private Integer addressId;

    @ApiModelProperty("共享类型。1:公开，2:私密，3:仅朋友可看")
    private Integer shareType;

}
