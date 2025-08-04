package cn.skuu.controller;

import cn.hutool.core.date.DateUtil;
import cn.skuu.adapter.SkuuBlogAdapter;
import cn.skuu.entity.SkuuBlog;
import cn.skuu.pojo.dto.FileTokenDto;
import cn.skuu.pojo.dto.SkuuBlogAddDto;
import cn.skuu.pojo.dto.SkuuBlogPageDto;
import cn.skuu.pojo.vo.FileTokenVo;
import cn.skuu.pojo.vo.ReturnVO;
import cn.skuu.service.ISkuuBlogService;
import cn.skuu.util.FileUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 博客 前端控制器
 * </p>
 *
 * @author dcx
 * @since 2025-06-07
 */
@Api(tags = "博客")
@RestController
@RequestMapping("/api/skuu-blog")
public class SkuuBlogController {
    //blog/日期/uid/名称
    private static final String KEY = "blog/%s/%s/%s";

    @Autowired
    private ISkuuBlogService iSkuuBlogService;

    @Autowired
    private SkuuBlogAdapter skuuBlogAdapter;

    @ApiOperation(value = "文件token")
    @PostMapping("/file-token")
    public ReturnVO<FileTokenVo> fileToken(@RequestBody FileTokenDto fileTokenDto) {
        String key = fileTokenDto.getKey();
        String format = String.format(KEY, DateUtil.date().toString("yyyyMMdd"), 11, key);
        FileTokenVo fileTokenVo = FileUtil.fileToken(format);
        return ReturnVO.ok(fileTokenVo);
    }

    @ApiOperation(value = "分页")
    @GetMapping("/page")
    public ReturnVO<Page<SkuuBlog>> page(SkuuBlogPageDto skuuBlogPageDto) {
        Page<SkuuBlog> pages = iSkuuBlogService.pageList(skuuBlogPageDto);
        return ReturnVO.ok(pages);
    }

    @ApiOperation(value = "保存")
    @GetMapping("/save")
    public ReturnVO<Boolean> save(@RequestBody SkuuBlogAddDto skuuBlogPageDto) {
        SkuuBlog skuuBlog = skuuBlogAdapter.skuuBlogAddDtoToEntity(skuuBlogPageDto);
        boolean save = iSkuuBlogService.save(skuuBlog);
        return ReturnVO.ok(save);
    }

}
