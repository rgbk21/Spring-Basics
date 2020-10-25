package com.example.rgbk.service.impl;

import com.example.rgbk.persistence.model.Project;
import com.example.rgbk.persistence.repository.IProjectRepository;
import com.example.rgbk.service.IProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements IProjectService, ApplicationContextAware {

    private IProjectRepository projectRepository;

    private static final Logger log = LoggerFactory.getLogger(ProjectServiceImpl.class);

    // Note how @Qualifier works for Constructor Injection
    public ProjectServiceImpl(@Qualifier("projectRepositoryImpl") IProjectRepository projectRepository) {
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

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("CONTEXT WITH ID '{}' SET", applicationContext.getId());
        log.info("Name of Application is {}", applicationContext.getApplicationName());

    }
}
