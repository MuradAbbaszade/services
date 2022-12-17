package world.rfch.service;

import world.rfch.jpa.entity.ServiceEntity;
import world.rfch.jpa.entity.UserEntity;

import java.util.List;

public interface UserService {
    boolean save(UserEntity userEntity) throws Exception;
    List<UserEntity> getAll();
    UserEntity getById(Long id) throws Exception;
    boolean deleteById(Long id) throws Exception;
    List<UserEntity> deleteAll();
    UserEntity findByEmail(String email) throws Exception;
}
