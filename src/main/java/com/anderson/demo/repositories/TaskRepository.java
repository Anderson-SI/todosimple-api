package com.anderson.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.anderson.demo.models.Task;

// @Repository
@NoRepositoryBean 
public interface TaskRepository extends JpaRepository<Task, Long> {

    

    List<Task> FindByUser_Id(Long id);
    
    // @Query(value = "SELECT t FROM Task t WHERE t.user.id = :id")
    // List<Task> FindByUserId (@Param("user_id") Long id);

    // @Query(value = "select * from task t where t.users_id = :id" ,nativeQuery = true)
    // List<Task> FindByUser_Id(@Param("id") Long id);

}
