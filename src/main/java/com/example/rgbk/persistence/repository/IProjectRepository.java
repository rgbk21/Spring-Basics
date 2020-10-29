package com.example.rgbk.persistence.repository;

import com.example.rgbk.persistence.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByName(String name);
    List<Project> findByDateCreatedBetween(LocalDate startDate, LocalDate endDate);

}
