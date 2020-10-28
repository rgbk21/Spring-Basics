package com.example.rgbk;

import com.example.rgbk.persistence.model.Project;
import com.example.rgbk.old_service.IProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestPropertySource(locations = {"classpath:application-test.properties", "classpath:test.properties"})
public class ProjectServiceIntegrationTest2 {

    @Autowired
    @Qualifier("projectServiceImpl")
    private IProjectService projectService;

    @Value("${project.prefix}")
    private String projectPrefix;

    @Value("${additional.info}")
    private String additionalValue;

    @Test
    public void whenTestPropertySource_thenValuesRetrieved() {
        assertEquals("Additional Info from test.properties", additionalValue);
    }

    @Test
    public void whenTestPropertySource_thenValuesRetrieved2() {
        assertEquals("PRO-TEST", projectPrefix);
    }

    @Test
    public void whenSavingProject_thenOK() {
        Project project = new Project("A New Project", LocalDate.now());
        Project savedProj = projectService.save(project);
        assertNotNull(savedProj);
    }

}