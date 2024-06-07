package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.Carrera;

@Repository
public interface MateriaRepository  extends JpaRepository<Materia,Integer> {

}
