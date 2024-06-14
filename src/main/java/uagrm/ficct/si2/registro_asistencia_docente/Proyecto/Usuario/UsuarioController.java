package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Usuario;

import lombok.AllArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo.Grupo;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo.GrupoService;
import uagrm.ficct.si2.registro_asistencia_docente.User.User;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RequestMapping("/api/users")
@RestController
/*@CrossOrigin*/
public class UsuarioController {

  private UsuarioService userService;

  @GetMapping
  public List<UserDTO> getAllUsers() {
    return userService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {
    Optional<UserDTO> userDTO = userService.findById(id);
    return userDTO.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping("/create")
  public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
    UserDTO savedUser = userService.save(userDTO);
    return ResponseEntity.ok(savedUser);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<UserDTO> updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
    userDTO.setId(id);
    UserDTO updatedUser = userService.save(userDTO);
    return ResponseEntity.ok(updatedUser);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
    userService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
