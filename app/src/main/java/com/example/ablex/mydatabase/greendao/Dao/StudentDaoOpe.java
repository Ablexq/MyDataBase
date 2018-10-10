package com.example.ablex.mydatabase.greendao.Dao;

import com.example.ablex.mydatabase.MyApplication;
import com.example.ablex.mydatabase.greendao.Bean.Student;
import com.example.ablex.mydatabase.greendao.gen.StudentDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class StudentDaoOpe {
    /**
     * 添加数据至数据库
     */
    public static void insertData(Student stu) {
        MyApplication.getDaoSession().getStudentDao().insert(stu);
    }

    /**
     * 将数据实体通过事务添加至数据库
     */
    public static void insertData(List<Student> list) {
        if (null == list || list.size() <= 0) {
            return;
        }
        MyApplication.getDaoSession().getStudentDao().insertInTx(list);
    }

    /**
     * 添加数据至数据库，如果存在，将原来的数据覆盖
     * 内部代码判断了如果存在就update(entity);不存在就insert(entity)；
     */
    public static void saveData(Student student) {
        MyApplication.getDaoSession().getStudentDao().save(student);
    }

    /**
     * 删除数据至数据库
     *
     * @param student 删除具体内容
     */
    public static void deleteData(Student student) {
        MyApplication.getDaoSession().getStudentDao().delete(student);
    }

    /**
     * 根据id删除数据至数据库
     *
     * @param id 删除具体内容
     */
    public static void deleteByKeyData(long id) {
        MyApplication.getDaoSession().getStudentDao().deleteByKey(id);
    }

    /**
     * 删除全部数据
     */
    public static void deleteAllData() {
        MyApplication.getDaoSession().getStudentDao().deleteAll();
    }

    /**
     * 更新数据库
     *
     * @param student
     */
    public static void updateData(Student student) {
        MyApplication.getDaoSession().getStudentDao().update(student);
    }

    /**
     * 查询所有数据
     */
    public static List<Student> queryAll() {
        QueryBuilder<Student> builder = MyApplication.getDaoSession().getStudentDao().queryBuilder();
        return builder.build().list();
    }

    /**
     * 分页加载
     *
     * @param pageSize 当前第几页(程序中动态修改pageSize的值即可)
     * @param pageNum  每页显示多少个
     */
    public static List<Student> queryPaging(int pageSize, int pageNum) {
        StudentDao studentDao = MyApplication.getDaoSession().getStudentDao();
        return studentDao.queryBuilder().offset(pageSize * pageNum).limit(pageNum).list();
    }
}
