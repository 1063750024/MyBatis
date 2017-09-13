package com.xdf.dao;

import com.xdf.bean.Student;
import com.xdf.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * alt +enter  快速实现方法
 */
public class StudentDaoImpl implements  StudentDao{

    /**
     * @param student  需要新增的学生对象
     */
    public void addStudent(Student student) {
     //获取session
        SqlSession session = null;
        try {
            session= SessionFactoryUtil.getSession();
            /**
             * 参数1：是我们执行的sql语句id
             * 参数2：如果方法是带参的  需要执行这个参数
             */
            session.insert("addStudent",student);
            //手动提交事务
            session.commit();
        }catch (Exception e){
             e.printStackTrace();
        }finally {
            //务必要关闭session
            session.close();
        }

    }
}
