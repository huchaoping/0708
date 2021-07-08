package com.ujiuye.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ObjectIdMap;
import com.ujiuye.entry.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/studentServlet")
public class StudentServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //根据实体类创建对象 并赋值
     Student stu1 = new Student(1,"mary",18);
     Student stu2 = new Student(2,"tom",19);
     Student stu3 = new Student(3,"jack",20);
     Student stu4 = new Student(4, "ccp", 33);

        //采用List 集合 存储实体类作用范围
     List<Student>list = new ArrayList<>();
     list.add(stu1);
     list.add(stu2);
     list.add(stu3);
     list.add(stu4);

        //对象映射器
        ObjectMapper mapper = new ObjectMapper();
        //字符串处理
        String res = mapper.writeValueAsString(list);
        System.out.println(res);
        PrintWriter writer = resp.getWriter();
        writer.print(res);
        writer.close();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
