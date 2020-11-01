package com.example.rgbk.persistence.model;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class Project {

    @Id
    private Long id;
    private String name;
    private LocalDate dateCreated;

    @Enumerated(EnumType.STRING)
    @Column(length = 16)
    private ProjectStatus projectStatus;

    private String internalId;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Task> tasks;

    public Project() {
    }

    public Project(Long id, String name, LocalDate dateCreated) {

        if(Objects.isNull(id)) {
            id = RandomUtils.nextLong();
        }

        this.id = id;
        this.name = name;
        this.dateCreated = dateCreated;
        this.projectStatus = ProjectStatus.STARTED;
        this.tasks = new HashSet<>();
    }


    public Project(Project project) {
        this(project.getId(), project.getName(), project.getDateCreated());
        this.tasks = new HashSet<>(project.tasks);
    }

    // Mapping to keep both parent-child sides in-sync
    public Project addTask(Task task){

        tasks.add(task);
        task.setProject(this);

        return this;
    }

    public Project removeTask(Task task){

        tasks.remove(task);
        task.setProject(null);

        return this;
    }

    public Set<Task> getTasks() {
        return this.tasks;
    }

    private void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
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

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getInternalId() {
        return internalId;
    }

    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }

    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }

    // Equals and Hash Code
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (!Objects.equals(id, project.id)) return false;
        if (!Objects.equals(name, project.name)) return false;
        if (!Objects.equals(dateCreated, project.dateCreated)) return false;
        if (projectStatus != project.projectStatus) return false;
        return Objects.equals(internalId, project.internalId);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (projectStatus != null ? projectStatus.hashCode() : 0);
        result = 31 * result + (internalId != null ? internalId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Project.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("dateCreated=" + dateCreated)
                .add("projectStatus=" + projectStatus)
                .add("internalId='" + internalId + "'")
                .toString();
    }
}
