package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Licencia;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Usuario.UserDTO;
import uagrm.ficct.si2.registro_asistencia_docente.User.User;
import uagrm.ficct.si2.registro_asistencia_docente.User.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LicenciaService {
  private LicenciaRepository licenciaRepository;

  public List<LicenciaDTO> findAll() {
    return licenciaRepository.findAll().stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
  }

  public Optional<LicenciaDTO> findById(Integer id) {
    return licenciaRepository.findById(id).map(this::convertToDto);
  }

  public LicenciaDTO save(LicenciaDTO licenciaDTO) {
    Licencia licencia = convertToEntity(licenciaDTO);
    licencia = licenciaRepository.save(licencia);
    return convertToDto(licencia);
  }

  public LicenciaDTO update(Integer id, LicenciaDTO licenciaDTO) {
    if (licenciaRepository.existsById(id)) {
      Licencia licencia = convertToEntity(licenciaDTO);
      licencia.setId(id); // Asegurar que el ID sea el correcto
      licencia = licenciaRepository.save(licencia);
      return convertToDto(licencia);
    } else {
      throw new EntityNotFoundException("Licencia not found with id " + id);
    }
  }

  public void deleteById(Integer id) {
    licenciaRepository.deleteById(id);
  }

  private LicenciaDTO convertToDto(Licencia licencia) {
    UserDTO userDTO = new UserDTO(
            licencia.getUser().getId(),
            licencia.getUser().getUsername(),
            licencia.getUser().getLastname(),
            licencia.getUser().getFirstname(),
            licencia.getUser().getCountry(),
            licencia.getUser().getCi(),
            licencia.getUser().getTelefono(),
            null /* Password no debería ser incluido en DTO */
    );
    return new LicenciaDTO(
            licencia.getId(),
            licencia.getHorario_inicio(),
            licencia.getHorario_fin(),
            licencia.getMotivo(),
            userDTO
    );
  }

  private Licencia convertToEntity(LicenciaDTO licenciaDTO) {
    User user = new User(
            licenciaDTO.getUserDTO().getId(),
            licenciaDTO.getUserDTO().getUsername(),
            licenciaDTO.getUserDTO().getLastname(),
            licenciaDTO.getUserDTO().getFirstname(),
            licenciaDTO.getUserDTO().getCountry(),
            licenciaDTO.getUserDTO().getCi(),
            licenciaDTO.getUserDTO().getTelefono(),
            null /* Password no debería ser asignado directamente */
    );
    return new Licencia(
            licenciaDTO.getId(),
            licenciaDTO.getHorario_inicio(),
            licenciaDTO.getHorario_fin(),
            licenciaDTO.getMotivo(),
            user
    );
  }
}
