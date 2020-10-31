package com.example.rgbk.persistence.repository;

import com.example.rgbk.persistence.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByName(String name);
}
