package pt.weldtrack.weld.track_api.service;


import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pt.weldtrack.weld.track_api.model.SoldadorEntity;
import pt.weldtrack.weld.track_api.repository.SoldadorRepository;

import java.util.List;
import java.util.Optional;

@Service

public class SoldadorService {

    private final SoldadorRepository repository;
    private final PasswordEncoder passwordEncoder;

    public SoldadorService(SoldadorRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<SoldadorEntity> getAll() {
        return repository.findAll();
    }

    public SoldadorEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Soldador não encontrado com o ID: " + id)
                );
    }

    public SoldadorEntity criar(SoldadorEntity s) {
        String hashPassword = passwordEncoder.encode(s.getPassword());
        s.setPassword(hashPassword);

        return repository.save(s);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
