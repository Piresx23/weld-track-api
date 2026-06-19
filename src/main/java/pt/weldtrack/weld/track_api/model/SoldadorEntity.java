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
@Table(name = "soldadores")

public class SoldadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "SOLDADOR_NAME", length = 50, nullable = false, unique = false)
    private String name;

    public String getName() {
        return name;
    }

}
