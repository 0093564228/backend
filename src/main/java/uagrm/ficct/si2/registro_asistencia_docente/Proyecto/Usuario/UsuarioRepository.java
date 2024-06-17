package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo.Grupo;
import uagrm.ficct.si2.registro_asistencia_docente.User.User;

/*@Repository*/
public interface UsuarioRepository extends JpaRepository<User,Integer> {
  /*List<User> findByProgramacionesIsNotNull();*/
}
