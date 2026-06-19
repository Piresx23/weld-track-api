package pt.weldtrack.weld.track_api.controller;


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
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
