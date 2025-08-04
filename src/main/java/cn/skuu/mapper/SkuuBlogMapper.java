package cn.skuu.mapper;

import cn.skuu.entity.SkuuBlog;
import cn.skuu.pojo.dto.SkuuBlogPageDto;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 博客 Mapper 接口
 * </p>
 *
 * @author dcx
 * @since 2025-06-07
 */
public interface SkuuBlogMapper extends BaseMapper<SkuuBlog> {

    Page<SkuuBlog> selectPageList(Page<SkuuBlog> page, @Param("skuuBlogPageDto") SkuuBlogPageDto skuuBlogPageDto);
}
