package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Aula;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends JpaRepository<Aula,Integer> {
}
