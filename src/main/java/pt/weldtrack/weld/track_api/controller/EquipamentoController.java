package pt.weldtrack.weld.track_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.weldtrack.weld.track_api.model.EquipamentoEntity;
import pt.weldtrack.weld.track_api.service.EquipamentoService;

import java.util.List;

@RestController
@RequestMapping("/api/equipamentos")
public class EquipamentoController {

    private final String CHAVE = "weldtrack123";

    private final EquipamentoService service;

    public EquipamentoController(EquipamentoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipamentoEntity> buscarPorId(@PathVariable Long id) {
        EquipamentoEntity equipamento = service.buscarPorId(id);
        return ResponseEntity.ok(equipamento);
    }

    @GetMapping
    public List<EquipamentoEntity> getAll() {
        return service.getAll();
    }

    @PostMapping
    public EquipamentoEntity criar(@RequestBody EquipamentoEntity eq) {
        return service.criar(eq);
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
}