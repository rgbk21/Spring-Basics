package com.example.rgbk.persistence.repository;

import com.example.rgbk.persistence.model.Project;

import java.util.Optional;

public interface IProjectRepository {

    Optional<Project> findById(Long id);

    Project save(Project project);


}
