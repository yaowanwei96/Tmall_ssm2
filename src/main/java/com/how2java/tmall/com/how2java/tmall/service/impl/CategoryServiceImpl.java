package com.how2java.tmall.com.how2java.tmall.service.impl;

import com.how2java.tmall.mapper.CategoryMapper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/12/26.
 */
//注解service声明当前类是一个service类
@Service
public class CategoryServiceImpl implements CategoryService {
    //通过自动装配@Autowired引入CategoryMapper，在list方法中调用
    @Autowired
    CategoryMapper categoryMapper;
   //CategoryMapperde list方法
    @Override
    public List<Category> list() {
        return categoryMapper.list() ;
    }
}
