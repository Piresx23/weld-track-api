package pt.weldtrack.weld.track_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.weldtrack.weld.track_api.model.EquipamentoEntity;
import pt.weldtrack.weld.track_api.repository.EquipamentoRepository;

import java.util.List;

@SpringBootApplication

public class WeldTrackApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeldTrackApiApplication.class, args);
	}

}

