package world.rfch.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import world.rfch.jpa.entity.ServiceEntity;

public interface ServiceJpaRepository extends JpaRepository<Long, ServiceEntity> {
}
