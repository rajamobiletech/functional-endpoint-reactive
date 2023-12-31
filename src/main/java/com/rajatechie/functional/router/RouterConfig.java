package com.rajatechie.functional.router;


import com.rajatechie.functional.Handler.EmployeeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Autowired
    private EmployeeHandler employeeHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions
                .route()
                .GET("/route/employee", employeeHandler::loadEmployees)
                .build();

    }
}
