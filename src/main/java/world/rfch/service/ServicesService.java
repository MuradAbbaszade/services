package world.rfch.service;

import world.rfch.jpa.entity.EmployeeEntity;
import world.rfch.jpa.entity.ServiceEntity;

import java.util.List;

public interface ServicesService {
    boolean add(ServiceEntity serviceEntity);
    List<ServiceEntity> getAll();
    ServiceEntity getById(Long id);
    boolean deleteById(Long id);
    boolean update(ServiceEntity serviceEntity);
}
