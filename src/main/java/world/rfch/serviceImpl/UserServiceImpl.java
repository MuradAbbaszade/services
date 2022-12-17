package world.rfch.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import world.rfch.jpa.entity.UserEntity;
import world.rfch.jpa.repository.UserJpaRepository;
import world.rfch.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserJpaRepository userJpaRepository;

    @Override
    public boolean save(UserEntity userEntity) throws Exception {
        try{
            userJpaRepository.save(userEntity);
            return true;
        }catch (Exception e){
            throw new Exception("An error occur while save user");
        }
    }

    @Override
    public List<UserEntity> getAll() {
        return userJpaRepository.findAll();
    }

    @Override
    public UserEntity getById(Long id) throws Exception {
        return userJpaRepository.findById(id)
                .orElseThrow(() -> new Exception("User not found"));
    }

    @Override
    public boolean deleteById(Long id) throws Exception {
        try{
            userJpaRepository.deleteById(id);
            return true;
        }catch(Exception e){
            throw new Exception("An error occur while delete user");
        }
    }

    @Override
    public List<UserEntity> deleteAll() {
        List<UserEntity> userEntities = getAll();
        userJpaRepository.deleteAll();
        return userEntities;
    }

    @Override
    public UserEntity findByEmail(String email) throws Exception {
        return userJpaRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("User not found"));
    }
}
