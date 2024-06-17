package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Usuario;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uagrm.ficct.si2.registro_asistencia_docente.User.Role;
import uagrm.ficct.si2.registro_asistencia_docente.User.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
  private Integer id;
  private String username;
  private String lastname;
  private String firstname;
  private String country;
  private String password;
  String ci;
  String telefono;
  Role role;

  public UserDTO(Integer id, String username, String lastname, String firstname, String country,String ci,String telefono, Object o) {
    this.id = id;
    this.username = username;
    this.lastname = lastname;
    this.firstname = firstname;
    this.country = country;
    this.ci = ci;
    this.telefono = telefono;
  }
}
