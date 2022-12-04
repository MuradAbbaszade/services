package world.rfch.serviceImpl;

import world.rfch.jpa.entity.ServiceEntity;
import world.rfch.service.ServicesService;

import java.util.List;

public class ServicesServiceImpl implements ServicesService {
    @Override
    public boolean add(ServiceEntity serviceEntity) {
        return false;
    }

    @Override
    public List<ServiceEntity> getAll() {
        return null;
    }

    @Override
    public ServiceEntity getById(Long id) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean update(ServiceEntity serviceEntity) {
        return false;
    }
}
