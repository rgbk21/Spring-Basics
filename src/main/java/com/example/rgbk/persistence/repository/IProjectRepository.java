package com.example.rgbk.persistence.repository;

import com.example.rgbk.persistence.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface IProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByName(String name);
    List<Project> findByDateCreatedBetween(LocalDate startDate, LocalDate endDate);

    @Query(
            value = "SELECT p.id, p.name, p.date_created, p.internal_id, p.project_status " +
                    "FROM project p " +
                    "WHERE p.name LIKE '%New%'",
            nativeQuery = true
    )
    List<Project> findByNameMatches_New();

    long deleteByName(String name);


}
