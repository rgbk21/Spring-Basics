package com.example.rgbk;

import com.example.rgbk.persistence.model.Project;
import com.example.rgbk.persistence.model.Task;
import com.example.rgbk.service.IProjectService;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;

// This test does not work for some reason. Dunno why
// @SpringBootTest annotation works with the same test
// But @SpringJUnitConfig doesn't.

// Update to above:
// This test works now. Had to change @PropertySource to @TestPropertySource

// We are telling this annotation exactly what configuration to use
// and that configuration will scan the entire package structure
@SpringJUnitConfig(value = TestConfig.class)
//@ActiveProfiles("dev") // Note without specifying the profile, we are getting error during autowiring the bean (actually, not anymore)
@TestPropertySource(locations = {"classpath:application-test.properties", "classpath:test.properties", "classpath:spy.properties"})
public class ProjectServiceIntegrationTest {

    @Autowired
    private IProjectService projectService;

    // You can see how we are reading value from 2 different property files
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
        Project project = new Project(RandomUtils.nextLong(),"ProjectServiceIntegrationTest - Project", LocalDate.now());
        Project savedProj = projectService.save(project);
        assertNotNull(savedProj);
    }

    @Test
    public void whenSavingAndFindingProjectById_thenOK(){

        long id = RandomUtils.nextLong();
        Project createdProject = new Project(id,"Saving_And_Finding_Project", LocalDate.now());
        projectService.save(createdProject);

        Optional<Project> savedProj = projectService.findById(id);
        Project foundProject = savedProj.get();
        assertEquals(foundProject, createdProject);
    }


    @Test
    public void whenSavingAndFindingProjectByName_thenOK(){

        String projectName = "Saving_And_Finding_Project_By_Name";
        Project createdProject = new Project(RandomUtils.nextLong(), projectName, LocalDate.now());
        projectService.save(createdProject);

        List<Project> projectList = projectService.findByName(projectName);
        assertThat(projectList).contains(createdProject);
    }

    @Test
    public void whenSavingAndFindingProjectByDateCreatedBetween_thenOK(){

        Project oldProject = new Project(RandomUtils.nextLong(), "Old Project", LocalDate.now().minusYears(1));
        Project newProject1 = new Project(RandomUtils.nextLong(), "New Project 1", LocalDate.now());
        Project newProject2 = new Project(RandomUtils.nextLong(), "New Project 2", LocalDate.now());

        projectService.save(oldProject);
        projectService.save(newProject1);
        projectService.save(newProject2);

        List<Project> foundProjects = projectService.findByDateCreatedBetween(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));

        assertThat(foundProjects).contains(newProject1, newProject2).doesNotContain(oldProject);

    }

    @Test
    public void testBatchingWhenProjectsAreSaved(){

        List<Project> projectList = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            Project project = new Project(RandomUtils.nextLong(), "Batch Project " + i, LocalDate.now());
            projectList.add(project);
        }

        projectService.saveAll(projectList);
    }

    @Test
    public void whenFindingProjectNamesContainingName_New_ThenOk(){

        Project oldProject = new Project(RandomUtils.nextLong(), "Old Project", LocalDate.now().minusYears(1));
        Project newProject1 = new Project(RandomUtils.nextLong(), "New Project 1", LocalDate.now());
        Project newProject2 = new Project(RandomUtils.nextLong(), "New Project 2", LocalDate.now());

        projectService.save(oldProject);
        projectService.save(newProject1);
        projectService.save(newProject2);

        List<Project> foundProjects = projectService.findByNameMatches_New();

        assertThat(foundProjects).contains(newProject1, newProject2).doesNotContain(oldProject);
    }

    @Test
    public void whenSavingAndFindingProjectAndTaskById_thenOK(){

        long projectId = RandomUtils.nextLong();
        long taskId1 = RandomUtils.nextLong();
        long taskId2 = RandomUtils.nextLong();

        Project createdProject = new Project(projectId,"SavingAndFinding_ProjectAndTask_ById", LocalDate.now());
        Task task1 = new Task(taskId1, "SavingAndFinding_ProjectAndTask_ById_Task1", LocalDate.now());
        Task task2 = new Task(taskId2, "SavingAndFinding_ProjectAndTask_ById_Task2", LocalDate.now());

        createdProject.addTask(task1);
        createdProject.addTask(task2);

        projectService.save(createdProject);

        Optional<Project> savedProj = projectService.findById(projectId);
        Project foundProject = savedProj.get();
        assertEquals(foundProject, createdProject);
    }

    @Test
    public void whenSavingAndDeletingAndThenFindingProjectAndTaskById_thenOK(){

        long projectId = RandomUtils.nextLong();
        long taskId1 = RandomUtils.nextLong();
        long taskId2 = RandomUtils.nextLong();

        Project createdProject = new Project(projectId,"SavingAndDeletingAndThenFindingProjectAndTaskById", LocalDate.now());
        Task task1 = new Task(taskId1, "SavingAndDeletingAndThenFindingProjectAndTaskById_Task1", LocalDate.now());
        Task task2 = new Task(taskId2, "SavingAndDeletingAndThenFindingProjectAndTaskById_Task2", LocalDate.now());

        createdProject.addTask(task1);
        createdProject.addTask(task2);

        projectService.save(createdProject);

        Optional<Project> savedProj = projectService.findById(projectId);
        Project foundProject = savedProj.get();
        assertEquals(foundProject, createdProject);
    }
}
