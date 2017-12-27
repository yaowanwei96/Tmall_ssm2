package com.how2java.tmall.mapper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.util.Page;

import java.util.List;


/**
 * Created by Administrator on 2017/12/26.
 */
public interface CategoryMapper {
      public List<Category> list(Page page);
      public int total();//数据库操作方法，一般在service中实现
      public void add(Category category);
      public void delete(int id);
      public Category get(int id);//sql语句中需要用到id
      public void update(Category category);
}
