package com.example.rgbk.old_service;

import com.example.rgbk.persistence.model.Project;

import java.util.Optional;

public interface IProjectService {

    Optional<Project> findById(Long id);

    Project save(Project project);

}
