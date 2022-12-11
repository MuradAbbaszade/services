package world.rfch.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import world.rfch.jpa.entity.EmployeeEntity;
import world.rfch.jpa.entity.FormEntity;
import world.rfch.jpa.repository.EmployeeJpaRepository;
import world.rfch.jpa.repository.FormJpaRepository;
import world.rfch.service.FormService;

import java.util.List;

@Service
public class FormServiceImpl implements FormService {

    @Autowired
    private FormJpaRepository formJpaRepository;

    @Override
    public boolean save(FormEntity formEntity) throws Exception {
        try{
            formJpaRepository.save(formEntity);
            return true;
        }catch (Exception e){
            throw new Exception("An error occur while save form");
        }
    }

    @Override
    public List<FormEntity> getAll() {
        return formJpaRepository.findAll();
    }

    @Override
    public FormEntity getById(Long id) throws Exception {
        return formJpaRepository.findById(id)
                .orElseThrow(() -> new Exception("Form not found"));
    }

    @Override
    public boolean deleteById(Long id) throws Exception {
        try{
            formJpaRepository.deleteById(id);
            return true;
        }catch(Exception e){
            throw new Exception("An error occur while delete form");
        }
    }

    @Override
    public List<FormEntity> deleteAll() {
        List<FormEntity> formEntities = getAll();
        formJpaRepository.deleteAll();
        return formEntities;
    }
}
