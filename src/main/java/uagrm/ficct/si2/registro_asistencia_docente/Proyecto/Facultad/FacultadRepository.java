package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultadRepository extends JpaRepository<Facultad, Integer> {
}
