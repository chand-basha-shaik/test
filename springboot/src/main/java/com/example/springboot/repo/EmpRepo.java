package com.example.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entity.Emp;

public interface EmpRepo extends JpaRepository<Emp, Integer>{

}
