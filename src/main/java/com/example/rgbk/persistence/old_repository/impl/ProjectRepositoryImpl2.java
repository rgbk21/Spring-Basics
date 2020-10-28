package com.example.rgbk.persistence.old_repository.impl;

import com.example.rgbk.persistence.model.Project;
import com.example.rgbk.persistence.old_repository.IProjectRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("prod")
public class ProjectRepositoryImpl2 implements IProjectRepository {

    List<Project> projects = new ArrayList<>();

    public ProjectRepositoryImpl2() {
        super();
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projects.stream().filter(project -> project.getId().equals(id)).findFirst();
    }

    @Override
    public Project save(Project project) {

        // We are doing both CREATE and UPDATE over here

        Project existingProject = findById(project.getId()).orElse(null);

        if (existingProject == null) {
            projects.add(project);
        } else {
            projects.remove(existingProject);
            Project newProject = new Project(project);
            projects.add(newProject);
        }

        return project;
    }
}
