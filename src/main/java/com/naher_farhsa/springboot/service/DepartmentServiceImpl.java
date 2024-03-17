package com.naher_farhsa.springboot.service;

import com.naher_farhsa.springboot.entity.Department;
import com.naher_farhsa.springboot.error.DepartmentNotFoundException;
import com.naher_farhsa.springboot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentByID(Long departmentID) throws DepartmentNotFoundException {
        // Here Optional (Object container ) is used to store department(object) with required ID.
        // It helps is to use isNull in efficient way (isPresent, isEmpty, isFull) to handle NullPointerException.
        Optional<Department> department= departmentRepository.findById(departmentID);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not Available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentByID(Long departmentID) {
        departmentRepository.deleteById(departmentID);
    }


    @Override
    public Department updateDepartment(Long departmentID, Department department) {
        Department dptDB = departmentRepository.findById(departmentID).get();
        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            dptDB.setDepartmentName(department.getDepartmentName());
        }
        else if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            dptDB.setDepartmentCode(department.getDepartmentCode());
        }
        else if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            dptDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepository.save(dptDB);

    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }


}
