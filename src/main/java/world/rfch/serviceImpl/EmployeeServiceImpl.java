package world.rfch.serviceImpl;

import world.rfch.jpa.entity.EmployeeEntity;
import world.rfch.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public boolean add(EmployeeEntity employeeEntity) {
        return false;
    }

    @Override
    public List<EmployeeEntity> getAll() {
        return null;
    }

    @Override
    public EmployeeEntity getById(Long id) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean update(EmployeeEntity employeeEntity) {
        return false;
    }
}
