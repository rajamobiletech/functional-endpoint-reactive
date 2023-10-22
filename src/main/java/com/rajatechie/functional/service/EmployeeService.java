package com.rajatechie.functional.service;


import com.rajatechie.functional.dao.EmployeeDao;
import com.rajatechie.functional.dto.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    public List<Employee> getEmployees() {
        return employeeDao.getEmployee();
    }

    public Flux<Employee> getEmployeesStream() {
        return employeeDao.getEmployeeStream();
    }
}
