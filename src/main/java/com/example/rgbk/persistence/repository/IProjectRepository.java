package com.example.rgbk.persistence.repository;

import com.example.rgbk.persistence.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectRepository extends JpaRepository<Project, Long> {

}
