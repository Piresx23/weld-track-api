package pt.weldtrack.weld.track_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.weldtrack.weld.track_api.model.RegistoTrabalhoEntity;

import java.util.List;

@Repository

public interface RegistoTrabalhoRepository extends JpaRepository<RegistoTrabalhoEntity, Long> {

    List<RegistoTrabalhoEntity> findBySoldadorId(Long soldadorId);

    List<RegistoTrabalhoEntity> findByEquipamentoId(Long equipamentoId);
    
}

