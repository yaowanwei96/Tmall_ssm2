package com.how2java.tmall.service.impl;
import com.how2java.tmall.util.Page;
import com.how2java.tmall.mapper.CategoryMapper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Administrator on 2017/12/26.
 */
//注解service声明当前类是一个service类
@Service
public class CategoryServiceImpl implements CategoryService {
    //通过自动装配@Autowired引入CategoryMapper，在list方法中调用
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public int total() {
        return categoryMapper.total();//调用Mapper里面数据库的方法
    }

    //CategoryMapperde list方法
    @Override
    public List<Category> list(Page page) {
        return categoryMapper.list(page) ;
    }

    @Override
    public void add(Category category) {
        categoryMapper.add(category);
    }

    @Override
    public void delete(int id) {
        categoryMapper.delete(id);
    }

    @Override
    public Category get(int id) {
        return categoryMapper.get(id);
    }

    @Override
    public void update(Category category) {
        categoryMapper.update(category);
    }


}
