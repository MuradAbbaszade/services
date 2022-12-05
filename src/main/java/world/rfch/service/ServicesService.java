package world.rfch.service;

import world.rfch.jpa.entity.ServiceEntity;

import java.util.List;

public interface ServicesService {
    boolean save(ServiceEntity serviceEntity) throws Exception;
    List<ServiceEntity> getAll();
    ServiceEntity getById(Long id) throws Exception;
    boolean deleteById(Long id) throws Exception;
    List<ServiceEntity> deleteAll();
}
