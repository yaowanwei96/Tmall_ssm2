package com.how2java.tmall.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Created by Administrator on 2017/12/27.
 */
public class TestTmall {
    public static void main(String args[]){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
            try (
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmall?useUnicode=true&characterEncoding=utf8",
                            "root", "102400")        ;
                    Statement s = c.createStatement();
            )
            {
                for (int i = 1; i <=30 ; i++) {
                    String sqlFormat = "insert into category values (null, '测试分类%d')";
                    String sql = String.format(sqlFormat, i+20);
                    s.execute(sql);
                }

                System.out.println("已经成功创建10条分类测试数据");

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

    }
}
