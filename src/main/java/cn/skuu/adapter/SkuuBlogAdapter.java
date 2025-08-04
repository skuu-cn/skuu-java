package cn.skuu.adapter;

import cn.skuu.entity.SkuuBlog;
import cn.skuu.pojo.dto.SkuuBlogAddDto;
import org.mapstruct.Mapper;

/**
 * @author dcx
 * @since 2022-08-30 23:30
 **/
@Mapper(componentModel = "spring")
public interface SkuuBlogAdapter {

    SkuuBlog skuuBlogAddDtoToEntity(SkuuBlogAddDto skuuBlogPageDto);
}
