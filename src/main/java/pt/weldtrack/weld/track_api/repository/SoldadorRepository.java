package pt.weldtrack.weld.track_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.weldtrack.weld.track_api.model.ConsumivelEntity;
import pt.weldtrack.weld.track_api.model.SoldadorEntity;

@Repository
public interface SoldadorRepository extends JpaRepository<SoldadorEntity, Long> {
}
