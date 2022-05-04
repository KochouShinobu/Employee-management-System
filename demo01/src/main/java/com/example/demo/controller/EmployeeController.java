package com.example.demo.controller;
import com.example.demo.dao.DepartmentDao;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.pojo.Department;
import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController{
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model){
        //获取所有员工信息
        Collection<Employee>employees=employeeDao.getEmployees();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    //添加
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //获取所有部门信息
        Collection<Department>departments=departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }
    @PostMapping("/addEmp")
    public  String addEmp(Employee employee,Integer departmentId){
        Department department=new Department();
        department.setId(departmentId);
        employee.setDepartment(department);
        employeeDao.save(employee); //保存员工信息
        return "redirect:/emps";
    }

    //修改
    @GetMapping("/emp/{id}")
    public  String toUpdateEmp(@PathVariable("id") Integer id,Model model){
        //查出员工原来的数据
       Employee employeeById=employeeDao.getEmployeeById(id);
        model.addAttribute("emp",employeeById);
        //获取所有部门信息
        Collection<Department>departments=departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/update";
    }
    @PostMapping("/updateEmp")
    public  String updateEmp(Employee employee,Integer departmentId){
        Department department=new Department();
        department.setId(departmentId);
        employee.setDepartment(department);
        employeeDao.save(employee); //保存员工信息
        return "redirect:/emps";
    }

    //删除
    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
