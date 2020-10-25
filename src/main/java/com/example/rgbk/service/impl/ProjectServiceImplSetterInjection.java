package com.example.rgbk.service.impl;

import com.example.rgbk.persistence.model.Project;
import com.example.rgbk.persistence.repository.IProjectRepository;
import com.example.rgbk.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImplSetterInjection implements IProjectService {

    private IProjectRepository projectRepository;

    @Autowired
    @Qualifier("projectRepositoryImpl")
    public void setProjectRepository(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

}

