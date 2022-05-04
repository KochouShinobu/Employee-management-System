package com.example.demo.pojo;

import sun.jvm.hotspot.types.CIntegerField;

public class Department {
    private Integer id;
    private String dept_name;

    public Department() {
    }

    public Department(Integer id, String dept_name){
        this.id=id;
        this.dept_name=dept_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }
}
