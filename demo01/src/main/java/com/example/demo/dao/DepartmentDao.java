package com.example.demo.dao;
import com.example.demo.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
 @Repository
public class DepartmentDao {
    private static Map<Integer,Department> departments=null;
    static{
        departments=new HashMap<Integer,Department>();
        departments.put(1,new Department(1,"市场部"));
        departments.put(2,new Department(2,"程序部"));
    }
    //获取所有部门信息
    public Collection<Department> getDepartments(){
        return departments.values();
    }
    //通过id得到部门
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}

