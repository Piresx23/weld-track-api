package service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import pt.weldtrack.weld.track_api.model.EquipamentoEntity;
import pt.weldtrack.weld.track_api.repository.EquipamentoRepository;
import pt.weldtrack.weld.track_api.service.EquipamentoService;
import java.util.Optional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EquipamentoServiceTeste {

    @Mock
    private EquipamentoRepository  equipamentoRepository;

    @InjectMocks
    private EquipamentoService equipamentoService;

    @Test
    void testeBuscarPorIdDeveLançarExceçaoQuandoNaoExiste () {

        when(equipamentoRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            equipamentoService.buscarPorId(99L);
        });
    }

    @Test
    void testeCriarGuardaDevolveEquipamento () {

        EquipamentoEntity equipamentoParaCriar = new EquipamentoEntity();
            equipamentoParaCriar.setName("Maquina Mig");;


        EquipamentoEntity equipamentoSalvo = new EquipamentoEntity();
            equipamentoSalvo.id = 1L;
            equipamentoSalvo.setName("Maquina Mig");

            when(equipamentoRepository.save(any(EquipamentoEntity.class))).thenReturn(equipamentoSalvo);

            EquipamentoEntity resultado = equipamentoService.criar(equipamentoParaCriar);

            assertNotNull(resultado);
            assertEquals(1L, resultado.id);
            assertEquals("Maquina Mig", resultado.getName());

    }
}
