package pt.weldtrack.weld.track_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.weldtrack.weld.track_api.model.SoldadorEntity;
import java.util.Optional;

public interface SoldadorRepository extends JpaRepository<SoldadorEntity, Long> {
    Optional<SoldadorEntity> findBySoldadorName(String soldadorName);
}