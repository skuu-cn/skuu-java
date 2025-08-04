package cn.skuu.service;

import cn.skuu.entity.SkuuBlog;
import cn.skuu.pojo.dto.SkuuBlogPageDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 博客 服务类
 * </p>
 *
 * @author dcx
 * @since 2025-06-07
 */
public interface ISkuuBlogService extends IService<SkuuBlog> {

    Page<SkuuBlog> pageList(SkuuBlogPageDto skuuBlogPageDto);
}
