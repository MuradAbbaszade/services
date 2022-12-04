package world.rfch.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import world.rfch.jpa.entity.EmployeeEntity;

public interface EmployeeJpaRepository extends JpaRepository<Long, EmployeeEntity> {
}
