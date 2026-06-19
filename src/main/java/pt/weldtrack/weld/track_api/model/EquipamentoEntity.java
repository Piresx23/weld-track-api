package pt.weldtrack.weld.track_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "equipamentos")

public class EquipamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "EQUIPAMENTO_NAME", length = 50, nullable = false, unique = false)
    private String name;


    public enum EstadoEquipamento {
        DISPONIVEL,
        EM_USO,
        MANUTENCAO
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoEquipamento estado = EstadoEquipamento.DISPONIVEL;
}
