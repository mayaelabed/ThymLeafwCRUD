package com.example.springbootThymeleafCRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootThymeleafCRUD.entity.Staff;

public interface StaffRepo extends JpaRepository<Staff, Integer> {
}