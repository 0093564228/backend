package uagrm.ficct.si2.registro_asistencia_docente;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
/*@EnableScheduling*/
public class RegistroAsistenciaDocenteApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistroAsistenciaDocenteApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(DataLoaderService dataLoaderService) {
		return args -> {
			dataLoaderService.loadData();
		};
	}
}
