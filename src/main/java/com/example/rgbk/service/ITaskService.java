package com.example.rgbk.service;

import com.example.rgbk.persistence.model.Project;
import com.example.rgbk.persistence.model.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskService {

    Optional<Task> findById(long id);
    List<Task> findByName(String name);
    Task save(Task task);

}
