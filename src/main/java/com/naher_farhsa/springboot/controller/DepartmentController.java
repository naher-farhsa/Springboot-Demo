package com.naher_farhsa.springboot.controller;

import com.naher_farhsa.springboot.entity.Department;
import com.naher_farhsa.springboot.error.DepartmentNotFoundException;
import com.naher_farhsa.springboot.service.DepartmentService;
import com.naher_farhsa.springboot.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
/*
RequestEntity: Represents an HTTP request with headers, a method, a URL, and a body, used for sending requests with additional metadata.
@RequestBody: Annotation in Spring used to bind the body of an HTTP request to a method parameter or a method-level parameter.
*/

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")  // " /departments " <-- this is called URI
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartment() {
        return departmentService.fetchDepartment();
    }

    @GetMapping("/departments/{id}") // " /departments/{id} " <-- "id" is mapped to departmentID as mentioned through @Pathvariable
    public Department fetchDepartmentByID(@PathVariable("id") Long departmentID) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentByID(departmentID);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentByID(@PathVariable("id") Long departmentID) {
        departmentService.deleteDepartmentByID(departmentID);
        return "Department deleted successfully!!";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentID, @RequestBody Department department) {
        return departmentService.updateDepartment(departmentID, department);
    }

    @GetMapping("/departments/name/{name}") //Here departmentName is used to fetch therefore "name" is used in Mapping
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName, @RequestParam Map<String,String> m) {
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
