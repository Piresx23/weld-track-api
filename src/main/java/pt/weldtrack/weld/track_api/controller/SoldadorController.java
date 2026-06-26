package pt.weldtrack.weld.track_api.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.weldtrack.weld.track_api.model.ConsumivelEntity;
import pt.weldtrack.weld.track_api.model.EquipamentoEntity;
import pt.weldtrack.weld.track_api.model.SoldadorEntity;
import pt.weldtrack.weld.track_api.service.SoldadorService;

import java.util.List;

@RestController
@RequestMapping ("/api/soldadores")

public class SoldadorController {

    private final String CHAVE = "weldtrack123";

    private final SoldadorService service;

    public SoldadorController(SoldadorService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoldadorEntity> buscarPorId(@PathVariable Long id) {
        SoldadorEntity equipamento = service.buscarPorId(id);
        return ResponseEntity.ok(equipamento);
    }

    @GetMapping
    public List<SoldadorEntity> getAll() {
        return service.getAll();
    }

    @PostMapping
    public SoldadorEntity criar(@RequestBody SoldadorEntity s) {
        return service.criar(s);
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
