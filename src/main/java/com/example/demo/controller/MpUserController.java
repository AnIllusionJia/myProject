package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.controller.base.BaseController;
import com.example.demo.entity.MpUser;
import com.example.demo.service.MpUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuan
 * @since 2019-05-11
 */
@RestController
@RequestMapping("/mp-user")
public class MpUserController extends BaseController {

    @Autowired
    private MpUserService mpUserService;

    /**
     * 添加一个新用户
     *
     * @author David Hong
     *
     * @return java.lang.Object
     */
    @GetMapping("/add")
    public Object post() {
        MpUser mpUser = new MpUser();
        mpUser.setUsername("yuan");
        mpUser.setAddress("广东深圳");
        mpUser.setOpenid("openid");
        mpUserService.save(mpUser);
        return "add";
    }

    /**
     * 通过id获取用户
     *
     * @author David Hong
     *
     * @param id
     * @return java.lang.Object
     */
    @GetMapping("/{id}")
    public Object get(@PathVariable Long id) {
        return mpUserService.getById(id);
    }

    /**
     * 通过id删除用户
     *
     * @author David Hong
     *
     * @param id
     * @return java.lang.Object
     */
    @GetMapping("/del/{id}")
    public Object del(@PathVariable Long id) {
        mpUserService.removeById(id);
        return "del";
    }


    public void PageList(){
        //添加条件 查询
        QueryWrapper<MpUser> query =    new QueryWrapper<MpUser>();
        query.eq("字段名","字段值");
        //根据条件分页
        //IPage<MpUser> mpUserIPage = mpUserService.page(new Page<>(pageNum, pageSize),query);
        //查询全部分页
        IPage<MpUser> mpUserIPage = mpUserService.page(new Page<>(pageNum, pageSize));
        List<MpUser> list =   mpUserIPage.getRecords();
        list.forEach(mp ->{
            System.out.println(mp.getId());
        });

    }



}