package com.employee.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.microservice.entity.EmployeeLogin;

public interface EmployeeLoginRepo extends JpaRepository<EmployeeLogin,String> {

}
