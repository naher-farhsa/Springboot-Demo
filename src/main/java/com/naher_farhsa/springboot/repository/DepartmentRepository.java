package com.naher_farhsa.springboot.repository;

import com.naher_farhsa.springboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> // Department - Entity/Table , Long - PrimaryKey
{
    public Department findByDepartmentName(String departmentName);

    public Department findByDepartmentNameIgnoreCase(String departmentName);
}