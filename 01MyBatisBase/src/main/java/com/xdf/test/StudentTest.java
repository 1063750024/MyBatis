package com.xdf.test;

import com.xdf.bean.Student;
import com.xdf.dao.StudentDao;
import com.xdf.dao.StudentDaoImpl;
import org.junit.jupiter.api.Test;

public class StudentTest {


    /**
     * 新增学生信息到数据库
     */
    @Test
    public   void  testAddStudent(){
        StudentDao dao=new StudentDaoImpl();
        dao.addStudent(new Student(11,"小白"));
    }
}
