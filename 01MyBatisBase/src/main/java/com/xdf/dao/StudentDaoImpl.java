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
             * 注意点：
             *    01.底层没有insert，delete 只有update
             *       001.点击insert观看源码
             *               新增操作
             *               public int insert(String statement, Object parameter) {
                             return this.update(statement, parameter);
                             }
                             删除方法
                             public int delete(String statement) {
                             return this.update(statement, (Object)null);
                             }
                    002.最终执行的是update！你怎么知道我到达执行的是新增还是删除呢？？？点进去update
                         001.根据mapper.xml文件中的sql语句！
                         002.只有sql语句  就能更新到数据库吗？
                         003.底层有一个属性叫dirty  是否是脏数据

                     session.commit()执行的时候，会进行缓存清理和flush（）操作！
                     缓存清理的时候会判断我们的对象是否是脏对象！如果是脏对象就会进行
                     同步数据库的操作！之后再把dirty 属性变为false！
             *
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
