package world.rfch.service;

import world.rfch.jpa.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    boolean save(EmployeeEntity employeeEntity) throws Exception;
    List<EmployeeEntity> getAll();
    EmployeeEntity getById(Long id) throws Exception;
    boolean deleteById(Long id) throws Exception;
    List<EmployeeEntity> deleteAll();
}
