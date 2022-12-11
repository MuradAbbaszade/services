package world.rfch.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import world.rfch.jpa.entity.EmployeeEntity;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<EmployeeEntity, Long> {
}
