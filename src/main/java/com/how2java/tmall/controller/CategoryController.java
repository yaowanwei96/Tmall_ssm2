package com.how2java.tmall.controller;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LQ on 2017/12/26.
 */
@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("admin_category_list")
    public String list(Model model){
        //通过categoryService.list()获取所有的Category对象，然后放在cs中
        //并服务端跳转到admin/listCategory（根据后续springMVC.xml）视图
        List<Category> cs=categoryService.list();
         model.addAttribute("cs", cs);
        return "admin/listCategory";
    }

}
