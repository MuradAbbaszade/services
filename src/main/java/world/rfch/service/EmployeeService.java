package world.rfch.service;

import world.rfch.jpa.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    boolean add(EmployeeEntity employeeEntity);
    List<EmployeeEntity> getAll();
    EmployeeEntity getById(Long id);
    boolean deleteById(Long id);
    boolean update(EmployeeEntity employeeEntity);
}
