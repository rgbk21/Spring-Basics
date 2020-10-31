package com.example.rgbk.persistence.model;

import org.apache.commons.lang3.RandomUtils;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
public class Task {

    @Id
    private Long id;

    private String name;

    private String description;

    private LocalDate dateCreated;
    
    @Column(length = 16)
    @Enumerated(value = EnumType.STRING)
    private TaskStatus status;

    @ManyToOne
    private Project project;

    public Task() {
    }

    public Task(Long id, String name, LocalDate dateCreated) {

        if(Objects.isNull(id)) {
            id = RandomUtils.nextLong();
        }

        this.id = id;
        this.name = name;
        this.dateCreated = dateCreated;
        this.status = TaskStatus.TO_DO;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
