package world.rfch.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import world.rfch.jpa.entity.PortfolioEntity;

@Repository
public interface PortfolioJpaRepository extends JpaRepository<PortfolioEntity, Long> {
}
