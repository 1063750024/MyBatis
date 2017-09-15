package com.xdf;

import com.xdf.bean.Student;
import com.xdf.dao.StudentDao;
import com.xdf.dao.StudentDaoImpl;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class StudentTest {

    StudentDao dao=null;
    Logger log=Logger.getLogger(StudentTest.class);

    /**
     * 在所有的test测试方法执行之前 都要执行的操作
     */
    @Before
    public void before(){
        dao=new StudentDaoImpl();
    }

    /**
     * 新增学生信息到数据库
     */

    @Test
    public   void  testAddStudent(){
        dao.addStudent(new Student(13,"小白3"));
    }

    /**
     * 删除
     */
    @Test
    public void delStudent(){
        dao.deleteStudent(13);
    }
    /**
     * 修改
     */
    @Test
    public void updateStudent(){
        Student student=new Student(14,555,"小尼古拉斯");
        dao.updateStudent(student);
    }
    /**
     * 查询所有 返回list
     */
    @Test
    public void listStudent(){
        List<Student> students = dao.selectAllStudents();
        log.debug(students);
    }

}
