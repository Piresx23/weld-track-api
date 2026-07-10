package pt.weldtrack.weld.track_api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "registo_trabalho")

public class RegistoTrabalhoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private String name;
    private Integer minutosTrabalhados;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "soldador_id", nullable = false)
    @JsonIgnoreProperties("registos")
    private SoldadorEntity soldador;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipamento_id", nullable = false)
    private EquipamentoEntity equipamento;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "consumivel_id", nullable = false)
    private ConsumivelEntity consumivel;

    public SoldadorEntity getSoldador() {
        return soldador;
    }

    public Integer getMinutosTrabalhados() {
        return minutosTrabalhados;
    }
}
