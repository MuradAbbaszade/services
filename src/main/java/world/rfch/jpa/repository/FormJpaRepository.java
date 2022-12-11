package world.rfch.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import world.rfch.jpa.entity.FormEntity;

public interface FormJpaRepository extends JpaRepository<FormEntity,Long> {
}
