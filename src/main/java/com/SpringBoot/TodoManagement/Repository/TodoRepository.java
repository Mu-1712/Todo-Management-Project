package com.SpringBoot.TodoManagement.Repository;

import com.SpringBoot.TodoManagement.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {


}
