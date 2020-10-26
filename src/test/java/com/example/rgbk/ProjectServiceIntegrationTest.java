package com.example.rgbk;

import com.example.rgbk.persistence.model.Project;
import com.example.rgbk.service.IProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

// This test does not work for some reason. Dunno why
// @SpringBootTest annotation works with the same test
// But @SpringJUnitConfig doesn't.

// We are telling this annotation exactly what configuration to use
// and that configuration will scan the entire package structure
@SpringJUnitConfig(value = App.class)
@ActiveProfiles("dev") // Note without specifying the profile, we are getting error during autowiring the bean
@PropertySource({"classpath:application.properties"})
public class ProjectServiceIntegrationTest {

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
