package com.example.demo.dao;
import com.example.demo.pojo.Department;
import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class EmployeeDao {
    //模拟数据库中的数据
    private static Map<Integer,Employee> employees=null;
    //员工所属的部门
    @Autowired
    private DepartmentDao departmentDao;
    static{
        employees=new HashMap<Integer,Employee>();
        employees.put(101,new Employee(101,"小王","2918291819@qq.com",new Department(1,"市场部")));
        employees.put(102,new Employee(102,"小李","2321828949@qq.com",new Department(2,"程序部")));
    }
    private static Integer initId = 103;
    public void save(Employee employee){ //保存员工信息
        if(employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }
    //删
    public void delete(Integer id){
        employees.remove(id);
    }
    //查询所有员工
    public Collection<Employee> getEmployees(){
        return employees.values();
    }
    //通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

}

