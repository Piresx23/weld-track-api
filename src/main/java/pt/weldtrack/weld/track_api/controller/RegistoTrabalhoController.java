package pt.weldtrack.weld.track_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.weldtrack.weld.track_api.model.RegistoTrabalhoEntity;
import pt.weldtrack.weld.track_api.service.RegistoTrabalhoService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/registotrabalho")
public class RegistoTrabalhoController {

    private final RegistoTrabalhoService service;

    public RegistoTrabalhoController(RegistoTrabalhoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistoTrabalhoEntity> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public List<RegistoTrabalhoEntity> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<RegistoTrabalhoEntity> criar(@RequestBody RegistoTrabalhoEntity r) {
        return ResponseEntity.ok(service.criar(r));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Registo " + id + " apagado com sucesso.");
    }

    @GetMapping("/estatisticas/minutos-por-soldador")
    public ResponseEntity<Map<String, Integer>> getMinutosPorSoldador() {
        return ResponseEntity.ok(service.calcularMinutosPorSoldador());
    }
}