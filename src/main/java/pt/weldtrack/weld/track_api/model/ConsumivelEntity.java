package pt.weldtrack.weld.track_api.model;

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
@Table(name = "consumiveis")

public class ConsumivelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantidadeStock;
    private int quantidadeMinima;

    private String nome;
    private int quantidade;
    public int getQuantidadeStock() {
        return quantidadeStock;
    }
    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }
}