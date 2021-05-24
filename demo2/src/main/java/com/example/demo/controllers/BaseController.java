package com.example.demo.controllers;

import com.example.demo.models.Company;
import com.example.demo.models.Employee;
import com.example.demo.repositories.AddressRepo;
import com.example.demo.repositories.CompanyRepo;
import com.example.demo.repositories.EmployeeRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@ResponseBody
public class BaseController {

    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping("/company/add")
    public Company addCompany(@RequestBody Company c)
    {
        return companyRepo.save(c);
    }

    @GetMapping("user/bycity")
    public List<Employee> getByCity(@RequestParam String city)
    {   System.out.println(city+"love");
        if(city == null)
        {
            return employeeRepo.findAll();
        }
        else
        {
            List<Employee> res=new ArrayList<>();
            List<Employee> temp=employeeRepo.findAll();
            for(Employee e:temp)
            {
                if(e.getAddress().getCity().equals(city))
                {
                    res.add(e);
                }
            }
            return res;
        }
    }

}
