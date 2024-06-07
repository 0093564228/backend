package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository  extends JpaRepository<Carrera,Integer> {

}
