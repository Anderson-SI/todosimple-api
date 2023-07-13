package com.anderson.demo.repositories;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.anderson.demo.models.Task;

//@NoRepositoryBean
@Repository 
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser_Id(Long id);
    
    // @Query(value = "SELECT t FROM Task t WHERE t.user.id = :id")
    // List<Task> FindByUserId (@Param("user_id") Long id);

    // @Query(value = "select * from task t where t.users_id = :id" ,nativeQuery = true)
    // List<Task> FindByUser_Id(@Param("id") Long id);

}
