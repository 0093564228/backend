package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Asistencia.programa_asistencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Asistencia.AsistenciaService;

@Component
public class AsistenciaScheduler {
  /*@Autowired
  private AsistenciaService asistenciaService;

  @Scheduled(fixedRate = 60000) // Ejecuta cada 60 segundos
  public void run() {
    asistenciaService.verificarYRegistrarFaltas();
  }*/
}
