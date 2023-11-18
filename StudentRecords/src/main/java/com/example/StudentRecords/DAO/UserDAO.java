package com.example.StudentRecords.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentRecords.model.UserModel;

public interface UserDAO extends JpaRepository<UserModel, Integer>{

}
