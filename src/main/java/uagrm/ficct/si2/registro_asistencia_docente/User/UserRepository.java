//package com.irojas.demojwt.User;
package uagrm.ficct.si2.registro_asistencia_docente.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Usuario.UserDTO;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);

    List<User> findByProgramacionesIsNotNull();

}
