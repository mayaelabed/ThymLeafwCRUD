package com.example.springbootThymeleafCRUD.Service;

import java.util.List;

import com.example.springbootThymeleafCRUD.entity.Staff;

public interface ServiceStaff {
    void save(Staff staff);

    List<Staff> getAll();

    Staff getById(Integer id);

    void delete(Staff staff);
}
