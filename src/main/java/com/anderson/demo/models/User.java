package com.anderson.demo.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;

import javax.naming.spi.DirStateFactory.Result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * Modelo de Usuário 
 */
@Entity
@Table (name = User.TABLE_USER)
public class User {

    public interface CreateUser {}
    public interface UpdateUser {}

    public static final String TABLE_USER = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;
    
    @Column(name = "username", length = 100, nullable = false)
    @NotNull(groups = CreateUser.class) 
    @NotEmpty(groups = CreateUser.class)
    @Size(groups = CreateUser.class, min = 2, max = 100)
    private String username;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(name = "password", length = 60, nullable = false)
    @NotEmpty(groups = {CreateUser.class, UpdateUser.class})
    @NotNull(groups = {CreateUser.class, UpdateUser.class})
    @Size(groups = {CreateUser.class, UpdateUser.class}, min = 8, max = 60)
    private String password;

    // private List<Task> tasks = new ArrayList<Task>();
    


    public User() {
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object objeto) {
        User other = (User) objeto;
        if (objeto == this)
            return true;
        if (objeto == null)
            return false;
        if (! (objeto instanceof User))
            return false; 
        if (this.id == null) 
            if (other.id != null) 
                return false;
            else if (!this.id.equals(other.id))
                return false;
        return Objects.equals(this.id, other.id) && Objects.equals(this.username, other.username) 
        && Objects.equals(this.password, other.password);
    }

    @Override
    public int hashCode() {
        int prime = 31, result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }

}