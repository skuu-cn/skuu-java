package cn.skuu.service.impl;

import cn.skuu.entity.SkuuBlog;
import cn.skuu.mapper.SkuuBlogMapper;
import cn.skuu.pojo.dto.SkuuBlogPageDto;
import cn.skuu.service.ISkuuBlogService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客 服务实现类
 * </p>
 *
 * @author dcx
 * @since 2025-06-07
 */
@Service
public class SkuuBlogServiceImpl extends ServiceImpl<SkuuBlogMapper, SkuuBlog> implements ISkuuBlogService {


    @Override
    public Page<SkuuBlog> pageList(SkuuBlogPageDto skuuBlogPageDto) {
        Integer pageNo = skuuBlogPageDto.getPageNo();
        Integer pageSize = skuuBlogPageDto.getPageSize();
        Page<SkuuBlog> page = Page.of(pageNo, pageSize);
        return baseMapper.selectPageList(page,skuuBlogPageDto);
    }
}
