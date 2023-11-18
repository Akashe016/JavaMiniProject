package com.example.EmployeeManagement.repoistry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeManagement.entity.EmployeeEntity;

@Repository
public interface EmployeeRepoistry extends JpaRepository<EmployeeEntity, Integer>{

}
