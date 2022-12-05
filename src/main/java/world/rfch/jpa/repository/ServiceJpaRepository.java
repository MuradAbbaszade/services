package world.rfch.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import world.rfch.jpa.entity.ServiceEntity;

@Repository
public interface ServiceJpaRepository extends JpaRepository<ServiceEntity, Long> {
}
