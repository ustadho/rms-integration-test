package com.mitrais.bootcamp.rms.controller;

import com.mitrais.bootcamp.rms.domain.Department;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartmentController {

    @GetMapping("/department/all")
    public List<Department> findAll(){
        List<Department> listAll = new ArrayList<>();
        listAll.add(new Department(1, "Department One"));
        listAll.add(new Department(2, "Department Two"));
        return listAll;
    }
}
