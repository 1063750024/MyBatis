package com.xdf.dao;

import com.xdf.bean.Student;

import java.util.List;
import java.util.Map;

/**
 * 动态查询
 */
public interface StudentDao {

    /**
     *  01.用户传递一个Student对象  但是我们不知道用户对那些属性赋了值
     */
    List<Student> selectStudentsByIf(Student student);

}
