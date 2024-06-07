package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.Facultad;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo,Integer> {
}