package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.Carrera;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.CarreraDTO;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.CarreraRepository;

import java.util.*;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class FacultadService {
  private FacultadRepository facultadRepository;

  @Transactional
  public List<FacultadDTO> findAll() {
    return facultadRepository.findAll().stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
  }

  @Transactional
  public Optional<FacultadDTO> findById(Integer id) {
    return facultadRepository.findById(id).map(this::convertToDto);
  }

  @Transactional
  public FacultadDTO save(FacultadDTO facultadDTO) {
    Facultad facultad = convertToEntity(facultadDTO);
    facultad = facultadRepository.save(facultad);
    return convertToDto(facultad);
  }

  @Transactional
  public void deleteById(Integer id) {
    facultadRepository.deleteById(id);
  }

  @Transactional
  public FacultadDTO update(FacultadDTO facultadDTO) {
    Facultad facultad = convertToEntity(facultadDTO);
    facultad = facultadRepository.save(facultad);
    return convertToDto(facultad);
  }

  public FacultadDTO convertToDto(Facultad facultad) {
    return new FacultadDTO(facultad.getId(), facultad.getNombre(), facultad.getModulo());
  }

  public Facultad convertToEntity(FacultadDTO facultadDTO) {
    return new Facultad(facultadDTO.getId(), facultadDTO.getNombre(),facultadDTO.getModulo(), null);
  }
}
