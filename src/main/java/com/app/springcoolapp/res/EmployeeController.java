package com.app.springcoolapp.res;

import com.app.springcoolapp.dao.EmployeeDao;
import com.app.springcoolapp.entity.Employee;
import com.app.springcoolapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if(employee==null){
            throw new RuntimeException("Employee not found for id: " + employeeId);
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee employee = employeeService.save(theEmployee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee modifyEmployee(@RequestBody Employee theEmployee){
        Employee employee = employeeService.findById(theEmployee.getId());

        if(employee==null){
            throw new RuntimeException("Employee not found for id: " + theEmployee.getId());
        }
        employee = employeeService.save(theEmployee);
        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String remove(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if(employee==null){
            throw new RuntimeException("Employee not found for id: " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Delete employee id: " + employeeId;
    }

}
