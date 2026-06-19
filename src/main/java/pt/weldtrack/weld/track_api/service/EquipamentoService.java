package pt.weldtrack.weld.track_api.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pt.weldtrack.weld.track_api.model.EquipamentoEntity;
import pt.weldtrack.weld.track_api.repository.EquipamentoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EquipamentoService {

    private final EquipamentoRepository repository;

    public EquipamentoService(EquipamentoRepository repository) {
        this.repository = repository;
    }

    public List<EquipamentoEntity> getAll() {
        return repository.findAll();
    }

    public EquipamentoEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Soldador não encontrado com o ID: " + id)
                );
    }

     public EquipamentoEntity criar(EquipamentoEntity eq) {

        return repository.save(eq);
    }

    public void delete(Long id) {

        repository.deleteById(id);
    }

}
