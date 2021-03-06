package com.how2java.tmall.controller;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.util.ImageUtil;
import com.how2java.tmall.util.Page;
import com.how2java.tmall.util.UploadedImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by LQ on 2017/12/26.
 */
@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("admin_category_list")
    public String list(Model model,Page page){
        //通过categoryService.list()获取所有的Category对象，然后放在cs中
        //并服务端跳转到admin/listCategory（根据后续springMVC.xml）视图
         List<Category> cs=categoryService.list(page);
         int total=categoryService.total();
         page.setTotal(total);//得到总页数之后，设置pojo中的total
         model.addAttribute("cs", cs);
         model.addAttribute("page",page);
        //服务端跳转到admin/listCategory.jsp页面，最后在listCategory.jsp中显示数据
         return "admin/listCategory";
    }

    @RequestMapping("admin_category_add")
    public String add(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
        System.out.println(c.getId());
        categoryService.add(c);
        System.out.println(c.getId());
        File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,c.getId()+".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        System.out.println(uploadedImageFile);
        System.out.println(uploadedImageFile.getImage());
        System.out.println(file);
        uploadedImageFile.getImage().transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);

        return "redirect:/admin_category_list";
    }


    @RequestMapping("admin_category_delete")
    public String delete(int id,HttpSession session) throws IOException {
        categoryService.delete(id);

        File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,id+".jpg");
        file.delete();

        return "redirect:/admin_category_list";
    }

    @RequestMapping("admin_category_edit")
    public String edit(int id, Model model) throws IOException{
        Category c=categoryService.get(id);
        model.addAttribute("c",c);
        return  "admin/editCategory";
    }

    @RequestMapping("admin_category_update")
    public String update(Category c,HttpSession session,UploadedImageFile uploadedImageFile)throws IOException{
        categoryService.update(c);
        MultipartFile image=uploadedImageFile.getImage();
        if(null!=image&&!image.isEmpty()){
            File imageFolder=new File(session.getServletContext().getRealPath("img/category"));
            File file=new File(imageFolder,c.getId()+".jpg");
            image.transferTo(file);
            BufferedImage img=ImageUtil.change2jpg(file);
            ImageIO.write(img,"jpg",file);
        }
        return "redirect:/admin_category_list";
    }
}
