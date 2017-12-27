package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.util.Page;

import java.util.List;

/**
 * Created by Administrator on 2017/12/26.
 *
 */
public interface CategoryService {
    int total();
    List<Category> list(Page page);
    void add(Category category);
    void delete(int id);
    public Category get(int id);
    void update(Category category);
}
