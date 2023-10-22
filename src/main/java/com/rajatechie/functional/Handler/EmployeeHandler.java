package com.rajatechie.functional.Handler;

import com.rajatechie.functional.dao.EmployeeDao;
import com.rajatechie.functional.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class EmployeeHandler {

    @Autowired
    EmployeeDao employeeDao;
    
    public Mono<ServerResponse> loadEmployees(ServerRequest request) {
        Flux<Employee> employees = employeeDao.getEmployeeStream();
        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(employees, Employee.class);
    }

}
