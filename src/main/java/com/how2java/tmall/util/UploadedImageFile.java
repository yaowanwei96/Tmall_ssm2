package com.how2java.tmall.util;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2017/12/27.
 */
public class UploadedImageFile {
    MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
