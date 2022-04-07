package com.example.employee.Controller;

import com.example.employee.Dto.EmployeeDto;
import com.example.employee.Entity.EmployeeEntity;
import com.example.employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@CrossOrigin
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;
        @Autowired
    public EmployeeController(EmployeeService employeeService) {

            this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public List<EmployeeEntity> GetAllEmployee(){
            List<EmployeeEntity> employee = employeeService.findAllEmployee();
            return employeeService.findAllEmployee();
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<EmployeeEntity> findById(@PathVariable("id") Integer id){
//        EmployeeEntity employee = employeeService.findById(id);
//        return new ResponseEntity<>(employee, HttpStatus.OK);
//    }

//
        @PostMapping("/add")
        public EmployeeEntity addEmployee(@RequestBody EmployeeEntity employeeEntity){
            return  employeeService.addEmployee(employeeEntity);
        }

        @PutMapping("/update/{id}")
    public EmployeeEntity updateEmployee(@PathVariable("id") Integer id ,@RequestBody EmployeeEntity employeeEntity){
            return employeeService.updateEmployee(id,employeeEntity);
        }

        @DeleteMapping("/delete/{id}")
    public boolean deleteEmployee(@PathVariable("id") Integer id){

            return employeeService.deleteEmployee(id);
        }

        @GetMapping("/tim/{id}")
            public EmployeeEntity getById(@PathVariable("id") Integer id){

            return employeeService.findEmployeeById(id);

        }
        @GetMapping("/kiem/{name}")
        public EmployeeEntity getByname(@PathVariable("name") String name){

            return employeeService.findByName(name);

        }

}
