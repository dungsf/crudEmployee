package com.example.employee.Service;

import com.example.employee.Entity.EmployeeEntity;
import com.example.employee.Repository.EmployeeRepository;
import com.example.employee.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }


    // hien thi nv
    public List<EmployeeEntity> findAllEmployee(){

        return employeeRepository.findAll();
    }

    //tim kiem id
    public EmployeeEntity findEmployeeById(Integer id){

        return employeeRepository.findEmployeeById(id);


    }

    //them
    public EmployeeEntity addEmployee(EmployeeEntity employeeEntity){

        return employeeRepository.save(employeeEntity);
    }

    //sua
    public EmployeeEntity updateEmployee(Integer id, EmployeeEntity employeeEntity){
        if(employeeEntity!= null){
            EmployeeEntity employeeEntity1 =employeeRepository.getById(id);
            if(employeeEntity1 != null){
                employeeEntity1.setName(employeeEntity.getName());
                employeeEntity1.setId(employeeEntity.getId());
                return employeeRepository.save(employeeEntity1);
            }
        }
        return null;
    }

    // xoa
        public boolean deleteEmployee(Integer id){
        if(id >= 1){
            EmployeeEntity employeeEntity =employeeRepository.getById(id);
        if(employeeEntity != null){
            employeeRepository.delete(employeeEntity);
            return true;
        }
                    }
            return false;
                    }
    public EmployeeEntity findByName(String name){

        return employeeRepository.findByName(name);



    }



}
