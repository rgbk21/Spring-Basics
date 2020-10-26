package com.example.rgbk;

import com.example.rgbk.persistence.model.Project;
import com.example.rgbk.service.IProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProjectServiceIntegrationTest2 {

    @Autowired
    @Qualifier("projectServiceImpl")
    private IProjectService projectService;

    @Test
    public void whenSavingProject_thenOK(){
        Project project = new Project("A New Project", LocalDate.now());
        Project savedProj = projectService.save(project);
        assertNotNull(savedProj);
    }

}