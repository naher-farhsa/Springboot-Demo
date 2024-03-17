package com.naher_farhsa.springboot.service;


import com.naher_farhsa.springboot.entity.Department;
import com.naher_farhsa.springboot.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> fetchDepartment();

    public Department fetchDepartmentByID(Long departmentID) throws DepartmentNotFoundException;

    public void deleteDepartmentByID(Long departmentID);

    public Department updateDepartment(Long departmentID, Department department);

    public Department fetchDepartmentByName(String departmentName);


}
