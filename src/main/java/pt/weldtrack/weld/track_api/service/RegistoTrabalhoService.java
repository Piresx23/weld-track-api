package pt.weldtrack.weld.track_api.service;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pt.weldtrack.weld.track_api.model.RegistoTrabalhoEntity;
import pt.weldtrack.weld.track_api.repository.RegistoTrabalhoRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class RegistoTrabalhoService {

    private final RegistoTrabalhoRepository repository;

    public RegistoTrabalhoService(RegistoTrabalhoRepository repository) {
        this.repository = repository;
    }

    public List<RegistoTrabalhoEntity> getAll() {
        return repository.findAll();
    }

    public RegistoTrabalhoEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Soldador não encontrado com o ID: " + id)
                );
    }
    public RegistoTrabalhoEntity criar(RegistoTrabalhoEntity r) {
        return repository.save(r);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Map<String, Integer> calcularMinutosPorSoldador() {
        List<RegistoTrabalhoEntity> registos = this.getALL();

        return registos.stream()
                .filter(r -> r.getSoldador() != null && r.getMinutosTrabalhados() != null)
                .collect(Collectors.groupingBy(
                        r -> r.getSoldador() .getName(),
                        Collectors.summingInt(RegistoTrabalhoEntity::getMinutosTrabalhados)
                ));
        
    }

    private List<RegistoTrabalhoEntity> getALL() {
        return List.of();
    }
}
