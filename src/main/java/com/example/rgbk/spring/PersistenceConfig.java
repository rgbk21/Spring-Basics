package com.example.rgbk.spring;

import com.example.rgbk.persistence.repository.impl.ProjectRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
- Add a breakpoint to the projectRepository() method
- If you remove the @Configuration annotation from this class and then run the debugger
you will see that the breakpoint is never hit.
- That would mean that the projectRepository bean is never added to the Spring Application Context
*/

//@Configuration
//public class PersistenceConfig {
//
//    @Bean
//    public ProjectRepositoryImpl projectRepository(){
//        return new ProjectRepositoryImpl();
//    }
//
//}
