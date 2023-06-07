package com.anderson.demo.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = Task.TABLE_TASK)
public class Task {

    private static final String TABLE_TASK = "task";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false, updatable = false)
    private User user;

    @Column(name = "description", length = 255, nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String description;


    public Task() {
    }

    public Task(Long id, User users, String description) {
        this.id = id;
        this.user = users;
        this.description = description;
    }
    
    @Override
    public boolean equals(Object objeto) {
     Task other = (Task) objeto;
        if (objeto == this)
            return true;
        if (objeto == null)
            return false;
        if (! (objeto instanceof Task))
            return false; 
        if (this.id == null) 
            if (other.id != null) 
                return false;
            else if (!this.id.equals(other.id))
                return false;
        return Objects.equals(this.id, other.id) && Objects.equals(this.user, other.user) 
        && Objects.equals(this.description, other.description);
    }

    @Override
    public int hashCode() {
        int prime = 31, result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User users) {
        this.user = users;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
