package com.project.javaspringpracticum.repository;
import com.project.javaspringpracticum.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{

}
