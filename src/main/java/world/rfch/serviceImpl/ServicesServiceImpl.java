package world.rfch.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import world.rfch.jpa.entity.ServiceEntity;
import world.rfch.jpa.repository.ServiceJpaRepository;
import world.rfch.service.ServicesService;

import java.util.List;

@Service
public class ServicesServiceImpl implements ServicesService {

    @Autowired
    private ServiceJpaRepository serviceJpaRepository;

    @Override
    public boolean save(ServiceEntity serviceEntity) throws Exception {
        try{
            serviceJpaRepository.save(serviceEntity);
            return true;
        }catch (Exception e){
            throw new Exception("An error occur while save service");
        }
    }

    @Override
    public List<ServiceEntity> getAll() {
        return serviceJpaRepository.findAll();
    }

    @Override
    public ServiceEntity getById(Long id) throws Exception {
        return serviceJpaRepository.findById(id)
                .orElseThrow(() -> new Exception("Service not found"));
    }

    @Override
    public boolean deleteById(Long id) throws Exception {
        try{
            serviceJpaRepository.deleteById(id);
            return true;
        }catch(Exception e){
            throw new Exception("An error occur while delete service");
        }
    }

    @Override
    public List<ServiceEntity> deleteAll() {
        List<ServiceEntity> serviceEntities = getAll();
        serviceJpaRepository.deleteAll();
        return serviceEntities;
    }
}
