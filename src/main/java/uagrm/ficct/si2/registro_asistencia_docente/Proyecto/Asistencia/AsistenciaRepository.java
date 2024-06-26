package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Asistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Licencia.Licencia;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer>{
  /*List<AsistenciaDTO> findByEstadoAndHorarioFinBefore(Estado estado, LocalDateTime dateTime);*/
}
