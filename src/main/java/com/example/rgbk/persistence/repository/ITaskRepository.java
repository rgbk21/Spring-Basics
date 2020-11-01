package com.example.rgbk.persistence.repository;

import com.example.rgbk.persistence.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByName(String name);
    long deleteByName(String name);
}
