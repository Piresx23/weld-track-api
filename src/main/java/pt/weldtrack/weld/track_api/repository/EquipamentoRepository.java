package pt.weldtrack.weld.track_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.weldtrack.weld.track_api.model.EquipamentoEntity;

@Repository

public interface EquipamentoRepository extends JpaRepository<EquipamentoEntity, Long> {
}








