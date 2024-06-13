package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Usuario;


import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo.Grupo;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo.GrupoRepository;
import uagrm.ficct.si2.registro_asistencia_docente.User.User;
import uagrm.ficct.si2.registro_asistencia_docente.User.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UsuarioService {
  private UserRepository userRepository;

  private PasswordEncoder passwordEncoder; // Necesario para cifrar contraseñas

  public List<UserDTO> findAll() {
    List<User> users = userRepository.findAll();
    return users.stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
  }

  public Optional<UserDTO> findById(Integer id) {
    Optional<User> userOptional = userRepository.findById(id);
    return userOptional.map(this::convertToDto);
  }

  public Optional<UserDTO> findByUsername(String username) {
    Optional<User> userOptional = userRepository.findByUsername(username);
    return userOptional.map(this::convertToDto);
  }

  public UserDTO save(UserDTO userDTO) {
    User user = convertToEntity(userDTO);

    // Cifrar la contraseña antes de guardarla
    user.setPassword(passwordEncoder.encode(user.getPassword()));

    user = userRepository.save(user);

    return convertToDto(user);
  }

  public void deleteById(Integer id) {
    userRepository.deleteById(id);
  }

  // Método para convertir de User a UserDTO
  private UserDTO convertToDto(User user) {
    return new UserDTO(user.getId(), user.getUsername(), user.getLastname(), user.getFirstname(),
            user.getCountry(), null, user.getRole());
  }

  // Método para convertir de UserDTO a User
  private User convertToEntity(UserDTO userDTO) {
    return User.builder()
            .id(userDTO.getId())
            .username(userDTO.getUsername())
            .lastname(userDTO.getLastname())
            .firstname(userDTO.getFirstname())
            .country(userDTO.getCountry())
            .password(userDTO.getPassword())
            .role(userDTO.getRole())
            .build();
  }
}
