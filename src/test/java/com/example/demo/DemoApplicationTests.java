package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.MpUser;
import com.example.demo.service.MpUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private MpUserService mpUserService;
    @Test
    public void contextLoads() {

        int pageNum = 1;
        int pageSize = 10;
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

    };
}
