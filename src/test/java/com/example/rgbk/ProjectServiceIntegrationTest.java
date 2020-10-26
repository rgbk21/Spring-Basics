package com.example.rgbk;

import com.example.rgbk.persistence.model.Project;
import com.example.rgbk.service.IProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

// This test does not work for some reason. Dunno why
// @SpringBootTest annotation works with the same test
// But @SpringJUnitConfig doesn't.

// Update to above:
// This test works now. Had to change @PropertySource to @TestPropertySource

// We are telling this annotation exactly what configuration to use
// and that configuration will scan the entire package structure
@SpringJUnitConfig(value = TestConfig.class)
//@ActiveProfiles("dev") // Note without specifying the profile, we are getting error during autowiring the bean (actually, not anymore)
@TestPropertySource(locations = {"classpath:application-test.properties", "classpath:test.properties"})
public class ProjectServiceIntegrationTest {

    @Autowired
    @Qualifier("projectServiceImpl")
    private IProjectService projectService;

    // You can how we are reading value from 2 different property files
    // additional.info is defined in test.properties
    @Value("${additional.info}")
    private String additionalValue;

    // project.prefix is defined in application-test.properties
    @Value("${project.prefix}")
    private String projectPrefix;

    @Test
    public void whenTestPropertySource_thenValuesRetrieved() {
        // Note the import that is being used for the assertEquals
        // import static org.junit.jupiter.api.Assertions.assertEquals;
        assertEquals("Additional Info from test.properties", additionalValue);
    }

    @Test
    public void whenTestPropertySource_thenValuesRetrieved2() {
        assertEquals("PRO-TEST", projectPrefix);
    }

    @Test
    public void whenSavingProject_thenOK(){
        Project project = new Project("A New Project", LocalDate.now());
        Project savedProj = projectService.save(project);
        assertNotNull(savedProj);
    }
}
