package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.Carrera;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.CarreraDTO;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.CarreraRepository;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.CarreraService;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.FacultadDTO;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion.Programacion;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion.ProgramacionDTO;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion.ProgramacionRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MateriaService {

  private MateriaRepository materiaRepository;

  private CarreraRepository carreraRepository;

  public List<MateriaDTO> findAll() {
    return materiaRepository.findAll().stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
  }

  public Optional<MateriaDTO> findById(Integer id) {
    return materiaRepository.findById(id).map(this::convertToDto);
  }

  public MateriaDTO save(MateriaDTO materiaDTO) {
    Materia materia = convertToEntity(materiaDTO);
    materia = materiaRepository.save(materia);
    return convertToDto(materia);
  }

  public void deleteById(Integer id) {
    materiaRepository.deleteById(id);
  }

  public MateriaDTO update(Integer id, MateriaDTO materiaDTO) {
    if (materiaRepository.existsById(id)) {
      Materia materia = convertToEntity(materiaDTO);
      materia.setId(id); // Asegurar que el ID sea el correcto
      materia = materiaRepository.save(materia);
      return convertToDto(materia);
    } else {
      throw new EntityNotFoundException("Materia not found with id " + id);
    }
  }

  private MateriaDTO convertToDto(Materia materia) {
    CarreraDTO carreraDTO = new CarreraDTO(materia.getCarrera().getId(), materia.getCarrera().getNombre(), null);
    return new MateriaDTO(materia.getId(), materia.getNombre(), materia.getSigla(), carreraDTO);
  }

  private Materia convertToEntity(MateriaDTO materiaDTO) {
    Optional<Carrera> carreraOptional = carreraRepository.findById(materiaDTO.getCarreraDTO().getId());
    if (carreraOptional.isEmpty()) {
      throw new EntityNotFoundException("Carrera not found with id " + materiaDTO.getCarreraDTO().getId());
    }
    Carrera carrera = carreraOptional.get();
    return new Materia(materiaDTO.getId(), materiaDTO.getNombre(), materiaDTO.getSigla(), carrera, null);
  }
}
