package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Asistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Licencia.Licencia;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer>{
}
