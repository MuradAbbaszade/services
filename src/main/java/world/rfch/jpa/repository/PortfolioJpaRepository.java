package world.rfch.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import world.rfch.jpa.entity.PortfolioEntity;

public interface PortfolioJpaRepository extends JpaRepository<Long, PortfolioEntity> {
}
