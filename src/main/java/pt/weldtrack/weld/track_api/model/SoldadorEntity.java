package pt.weldtrack.weld.track_api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "soldadores")
public class SoldadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY) // Esconde do POST/PUT no Swagger
    private Long id;

    @Column(name = "soldador_name", nullable = false)
    private String soldadorName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "papel", nullable = false)
    private String papel;

    public SoldadorEntity() {}

    public SoldadorEntity(String soldadorName, String password, String papel) {
        this.soldadorName = soldadorName;
        this.password = password;
        this.papel = papel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoldadorName() {
        return soldadorName;
    }

    public void setSoldadorName(String soldadorName) {
        this.soldadorName = soldadorName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }
}