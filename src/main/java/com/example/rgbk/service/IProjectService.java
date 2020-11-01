package com.example.rgbk.service;

import com.example.rgbk.persistence.model.Project;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IProjectService {

    Optional<Project> findById(long id);
    List<Project> findByName(String name);
    List<Project> findByDateCreatedBetween(LocalDate startDate, LocalDate endDate);
    List<Project> findByNameMatches_New();

    Project save(Project project);
    Project saveAndFlush(Project project);
    List<Project> saveAll(List<Project> project);

    long deleteByName(String name);
    void deleteById(long id);

}
