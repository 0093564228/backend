//package com.irojas.demojwt.User;
package uagrm.ficct.si2.registro_asistencia_docente.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username); 
}
