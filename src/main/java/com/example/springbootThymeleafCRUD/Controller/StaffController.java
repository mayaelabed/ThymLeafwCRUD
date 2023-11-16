package com.example.springbootThymeleafCRUD.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springbootThymeleafCRUD.Service.ServiceStaff;
import com.example.springbootThymeleafCRUD.entity.Staff;

@Controller
public class StaffController {
    @Autowired
    ServiceStaff Servicestaff;

    @GetMapping("/")
    public String getAllSatffs(Model model) {
        List<Staff> staffList = Servicestaff.getAll();

        if (staffList.size() > 0) {
            model.addAttribute("staffs", staffList);
        }
        return "list-staffs";
    }

    @GetMapping("/add-staff")
    public String addStaff(Model model) {
        model.addAttribute("staff", new Staff());
        return "add-edit-staff";
    }

    @PostMapping("/save-staff")
    public String saveStaff(Staff staff) {
        Servicestaff.save(staff);
        return "redirect:/";
    }

    @GetMapping("/staff-update/{id}")
    public String getStaff(Model model, @PathVariable("id") Integer id) {
        Staff staff = Servicestaff.getById(id);
        model.addAttribute("staff", staff);
        return "add-edit-staff";
    }

    @GetMapping("/staff-delete/{id}")
    public String deleteStaff(@PathVariable("id") Integer id) {
        Staff deleteStaff = Servicestaff.getById(id);
        Servicestaff.delete(deleteStaff);
        return "redirect:/";
    }
}
