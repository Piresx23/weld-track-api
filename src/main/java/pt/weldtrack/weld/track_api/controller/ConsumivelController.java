package pt.weldtrack.weld.track_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.weldtrack.weld.track_api.model.ConsumivelEntity;
import pt.weldtrack.weld.track_api.model.EquipamentoEntity;
import pt.weldtrack.weld.track_api.service.ConsumivelService;

import java.util.List;

@RestController
@RequestMapping("/api/consumiveis")

public class ConsumivelController {

    private final String CHAVE = "weldtrack123";

    private final ConsumivelService service;

    public ConsumivelController(ConsumivelService service) {
        this.service = service;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ConsumivelEntity> buscarPorId(@PathVariable Long id) {
        ConsumivelEntity equipamento = service.buscarPorId(id);
        return ResponseEntity.ok(equipamento);
    }

    @GetMapping
    public List<ConsumivelEntity> getAll() {
        return service.getAll();
    }


    @PostMapping
    public ConsumivelEntity criar(@RequestBody ConsumivelEntity c) {
        return service.criar(c);
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

    @GetMapping("/stock-baixo")
    public List<ConsumivelEntity> getStockBaixo() {
        return service.getStockBaixo();
    }
}