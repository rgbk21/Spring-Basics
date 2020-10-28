package com.example.rgbk.service.impl;

import com.example.rgbk.persistence.model.Project;
import com.example.rgbk.persistence.repository.IProjectRepository;
import com.example.rgbk.service.IProjectService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements IProjectService {

    private IProjectRepository projectRepository;

    @Value("${project.prefix}")
    private String prefix;

    @Value("${project.suffix}")
    private Integer suffix;

    public ProjectServiceImpl(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<Project> findById(long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        updateInternalId(project);
        return projectRepository.save(project);
    }

    // Recall we were trying to do this (inject values from the property file)
    // within the @Entity class but it was not working
    // because the lifecycle of @Entity is not managed by Spring
    private void updateInternalId(Project project){
        project.setInternalId(prefix + "::" + project.getId() + "::" + suffix);
    }
}
