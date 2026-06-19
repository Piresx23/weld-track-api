package pt.weldtrack.weld.track_api.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.weldtrack.weld.track_api.model.EquipamentoEntity;
import pt.weldtrack.weld.track_api.model.RegistoTrabalhoEntity;
import pt.weldtrack.weld.track_api.service.RegistoTrabalhoService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/registotrabalho")

public class RegistoTrabalhoController{

    private final RegistoTrabalhoService service;

    private final String CHAVE = "weldtrack123";

    public RegistoTrabalhoController(RegistoTrabalhoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistoTrabalhoEntity> buscarPorId(@PathVariable Long id) {
        RegistoTrabalhoEntity equipamento = service.buscarPorId(id);
        return ResponseEntity.ok(equipamento);
    }

    @GetMapping
    public List<RegistoTrabalhoEntity> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<?> criar(
            @RequestBody RegistoTrabalhoEntity r,
            @RequestHeader(value = "X-Admin-Key", required = false) String chaveRecebida) {
        if (chaveRecebida == null || !chaveRecebida.equals(CHAVE)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Erro: nao tem autorizaçãoo para criar registos");
        }
        return ResponseEntity.ok(service.criar(r));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id,
            @RequestHeader(value = "X-Admin-Key", required = false) String chaveRecebida) {
        if (chaveRecebida == null || !chaveRecebida.equals(CHAVE)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Erro: nao tem autorizaçãoo para criar registos");
        }
        service.delete(id);
        return ResponseEntity.ok("Registo " + id + " apagado com sucesso.");
    }

    @GetMapping("/estatisticas/minutos-por-soldador")
    public ResponseEntity<Map<String, Integer>> getMinutosPorSoldador() {
        return ResponseEntity.ok(service.calcularMinutosPorSoldador());
    }
}


