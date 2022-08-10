package com.endava.tmd.dap.entity;

import com.endava.tmd.dap.enumeration.Label;
import com.endava.tmd.dap.enumeration.Priority;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Objects;

@Entity
@Table(name = "Task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private String description;

    private Calendar dueDate;

    private Calendar createdDate;

    private Label status;

    private Priority priority;


    public Task(){
    }

    public Task(final String title, final String description, final Calendar dueDate, final Label status, final Priority priority){
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.createdDate = Calendar.getInstance();
        this.status = status;
        this.priority = priority;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getDueDate() {
        return dueDate;
    }

    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
    }

    public Calendar getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Calendar createdDate) {
        this.createdDate = createdDate;
    }

    public Label getStatus() {
        return status;
    }

    public void setStatus(Label status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString(){
        return "Task[id: " + id + ", title: " + title + ", description: " + description + ", dueDate: " + dueDate + ", createdDate: " + createdDate + ", status: " + status + ", priority: " + priority + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return getTitle().equals(task.getTitle()) && Objects.equals(getDescription(), task.getDescription()) && Objects.equals(getDueDate(), task.getDueDate()) && getCreatedDate().equals(task.getCreatedDate()) && getStatus() == task.getStatus() && getPriority() == task.getPriority();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getDescription(), getDueDate(), getCreatedDate(), getStatus(), getPriority());
    }
}
