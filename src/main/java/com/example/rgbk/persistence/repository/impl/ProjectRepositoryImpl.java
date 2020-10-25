package com.example.rgbk.persistence.repository.impl;

import com.example.rgbk.persistence.model.Project;
import com.example.rgbk.persistence.repository.IProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProjectRepositoryImpl implements IProjectRepository {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectRepositoryImpl.class);

    @Value("${project.prefix}")
    private String prefix;

    @Value("${project.suffix}")
    private Integer suffix;

    List<Project> projects = new ArrayList<>();

    public ProjectRepositoryImpl() {
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

        // Adding this method to show how values can be read from the application.properties file
        updateInternalId(project);

        if (existingProject == null) {
            projects.add(project);
        } else {
            projects.remove(existingProject);
            Project newProject = new Project(project);
            projects.add(newProject);
        }

        return project;
    }

    private void updateInternalId(Project project) {

        LOG.info("Prepending Prefix " + prefix);
        LOG.info("Appending Suffix " + suffix);

        project.setInternalId(prefix + "-" + project.getId() + "-" + suffix);

        LOG.info("Generated internal id " + project.getInternalId());
    }
}
