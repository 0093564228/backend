package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramacionRepository extends JpaRepository<Programacion, Integer> {
}
