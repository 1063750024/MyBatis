package com.xdf;

import com.xdf.bean.Student;
import com.xdf.dao.StudentDao;
import com.xdf.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentTest {

    StudentDao dao=null;
    SqlSession session=null;
    Logger log=Logger.getLogger(StudentTest.class);

    /**
     * 在所有的test测试方法执行之前 都要执行的操作
     */
    @Before
    public void before(){
        //获取session
        session= SessionFactoryUtil.getSession();
        dao=session.getMapper(StudentDao.class); //获取执行的类对象
    }

    @After
    public  void after(){
        if (session!=null){
            session.close();
        }
    }

  //使用map 查询 姓名中带  小 ，年龄大于100 的 学生信息
    @Test
    public  void  testIf(){
        Student  student=new Student();
        //01.用户什么属性都没有赋值
        //02.用户传递了name       student.setName("小");
        //03.用户传递了age         student.setAge(555);
        //04.name和age都进行了赋值
        student.setName("小");
        student.setAge(555);
        List<Student> students = dao.selectStudentsByIf(student);
        log.debug(students);


    }




}
