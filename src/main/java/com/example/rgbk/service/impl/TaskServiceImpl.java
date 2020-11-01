package com.example.rgbk.service.impl;

import com.example.rgbk.persistence.model.Task;
import com.example.rgbk.persistence.repository.ITaskRepository;
import com.example.rgbk.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private ITaskRepository taskRepository;

    @Override
    public Optional<Task> findById(long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> findByName(String name) {
        return taskRepository.findByName(name);
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public long deleteByName(String name) {
        return taskRepository.deleteByName(name);
    }

    @Override
    public void deleteById(long id) {
        taskRepository.deleteById(id);
    }
}
