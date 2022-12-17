package world.rfch.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import world.rfch.jpa.entity.UserEntity;

import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity,Long> {
    @Query(value = "select * from user where email=:email",nativeQuery = true)
    Optional<UserEntity> findByEmail(@Param("email") String email);
}
