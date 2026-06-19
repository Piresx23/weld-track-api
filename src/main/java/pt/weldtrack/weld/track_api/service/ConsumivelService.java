package pt.weldtrack.weld.track_api.service;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pt.weldtrack.weld.track_api.model.ConsumivelEntity;
import pt.weldtrack.weld.track_api.model.EquipamentoEntity;
import pt.weldtrack.weld.track_api.repository.ConsumivelRepository;
import pt.weldtrack.weld.track_api.repository.EquipamentoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumivelService {

    private final ConsumivelRepository repository;

    public ConsumivelService(ConsumivelRepository repository) {
        this.repository = repository;
    }

    public List<ConsumivelEntity> getAll() {
        return repository.findAll();
    }

    public ConsumivelEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Soldador não encontrado com o ID: " + id)
                );
    }

    public ConsumivelEntity criar(ConsumivelEntity c) {
        return repository.save(c);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<ConsumivelEntity> getStockBaixo() {
        return repository.findAll()
                .stream()
                .filter(c -> c.getQuantidadeStock() < c.getQuantidadeMinima())
                .toList();
    }
}