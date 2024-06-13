package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Licencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion.Programacion;

@Repository
public interface LicenciaRepository extends JpaRepository<Licencia, Integer> {
}
