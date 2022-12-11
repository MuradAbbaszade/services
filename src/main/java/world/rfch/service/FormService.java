package world.rfch.service;

import world.rfch.jpa.entity.EmployeeEntity;
import world.rfch.jpa.entity.FormEntity;

import java.util.List;

public interface FormService {
    boolean save(FormEntity formEntity) throws Exception;
    List<FormEntity> getAll();
    FormEntity getById(Long id) throws Exception;
    boolean deleteById(Long id) throws Exception;
    List<FormEntity> deleteAll();
}
