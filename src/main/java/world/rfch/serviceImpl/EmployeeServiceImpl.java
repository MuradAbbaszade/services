package world.rfch.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import world.rfch.jpa.entity.EmployeeEntity;
import world.rfch.jpa.repository.EmployeeJpaRepository;
import world.rfch.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    @Override
    public boolean save(EmployeeEntity employeeEntity) throws Exception {
        try{
            employeeJpaRepository.save(employeeEntity);
            return true;
        }catch (Exception e){
            throw new Exception("An error occur while save employee");
        }
    }

    @Override
    public List<EmployeeEntity> getAll() {
        return employeeJpaRepository.findAll();
    }

    @Override
    public EmployeeEntity getById(Long id) throws Exception {
        return employeeJpaRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee not found"));
    }

    @Override
    public boolean deleteById(Long id) throws Exception {
        try{
            employeeJpaRepository.deleteById(id);
            return true;
        }catch(Exception e){
            throw new Exception("An error occur while delete employee");
        }
    }

    @Override
    public List<EmployeeEntity> deleteAll() {
        List<EmployeeEntity> employeeEntities = getAll();
        employeeJpaRepository.deleteAll();
        return employeeEntities;
    }
}
