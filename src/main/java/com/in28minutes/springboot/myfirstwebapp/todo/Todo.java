package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

//Database (MySQL)
//Static List of todos => Database (H2, MySQL)

//JPA
// Bean -> DataBase (Entity 어노테이션을 통해 Table 생성)

@Entity
public class Todo {

    @Id
    @GeneratedValue
    private long id;

    private String username;
    @Size(min = 10, message = "Enter atleast 10 characters")
    private String description;
    private LocalDate targetDate;
    private boolean done;

    // 생성자
    public Todo() {
    }

    public Todo(long id, String username, String description, LocalDate targetDate, boolean done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    // getter, setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    // toString

    @Override
    public String toString() {
        return "Todo{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", description='" + description + '\'' +
            ", targetDate=" + targetDate +
            ", done=" + done +
            '}';
    }
}
