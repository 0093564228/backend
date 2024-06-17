package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Asistencia;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo.Grupo;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo.GrupoDTO;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.Materia;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.MateriaDTO;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Aula.Aula;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Aula.AulaDTO;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion.Programacion;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion.ProgramacionDTO;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Usuario.UserDTO;
import uagrm.ficct.si2.registro_asistencia_docente.User.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AsistenciaService {
  private AsistenciaRepository asistenciaRepository;

  public List<AsistenciaDTO> findAll() {
    return asistenciaRepository.findAll().stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
  }

  public Optional<AsistenciaDTO> findById(Integer id) {
    return asistenciaRepository.findById(id).map(this::convertToDto);
  }

  public AsistenciaDTO save(AsistenciaDTO asistenciaDTO) {
    Asistencia asistencia = convertToEntity(asistenciaDTO);
    asistencia = asistenciaRepository.save(asistencia);
    return convertToDto(asistencia);
  }

  public AsistenciaDTO update(Integer id, AsistenciaDTO asistenciaDTO) {
    if (asistenciaRepository.existsById(id)) {
      Asistencia asistencia = convertToEntity(asistenciaDTO);
      asistencia.setId(id); // Asegurar que el ID sea el correcto
      asistencia = asistenciaRepository.save(asistencia);
      return convertToDto(asistencia);
    } else {
      throw new EntityNotFoundException("Asistencia not found with id " + id);
    }
  }

  public void deleteById(Integer id) {
    asistenciaRepository.deleteById(id);
  }

  private AsistenciaDTO convertToDto(Asistencia asistencia) {
    ProgramacionDTO programacionDTO = asistencia.getProgramacion() != null ?
            convertToDto(asistencia.getProgramacion()) :
            null;
    return new AsistenciaDTO(
            asistencia.getId(),
            asistencia.getHorario_inicio(),
            asistencia.getHorario_fin(),
            asistencia.getEstado(),
            programacionDTO
    );
  }

  private Asistencia convertToEntity(AsistenciaDTO asistenciaDTO) {
    Programacion programacion = asistenciaDTO.getProgramacionDTO() != null ?
            convertToEntity(asistenciaDTO.getProgramacionDTO()) :
            null;
    return new Asistencia(
            asistenciaDTO.getId(),
            asistenciaDTO.getHorario_inicio(),
            asistenciaDTO.getHorario_fin(),
            asistenciaDTO.getEstado(),
            programacion
    );
  }

  // Métodos adicionales de conversión si son necesarios

  private ProgramacionDTO convertToDto(Programacion programacion) {
    MateriaDTO materiaDTO = programacion.getMateria() != null ?
            new MateriaDTO(programacion.getMateria().getId(), programacion.getMateria().getNombre(), programacion.getMateria().getSigla(), null) :
            null;
    GrupoDTO grupoDTO = programacion.getGrupo() != null ?
            new GrupoDTO(programacion.getGrupo().getId(), programacion.getGrupo().getNombre()) :
            null;
    AulaDTO aulaDTO = programacion.getAula() != null ?
            new AulaDTO(programacion.getAula().getId(), programacion.getAula().getNombre()) :
            null;
    UserDTO userDTO = programacion.getUser() != null ?
            new UserDTO(programacion.getUser().getId(), programacion.getUser().getUsername(), programacion.getUser().getLastname(), programacion.getUser().getFirstname(), programacion.getUser().getCountry(),programacion.getUser().getCi(),programacion.getUser().getTelefono(), null) :
            null;
    return new ProgramacionDTO(
            programacion.getId(),
            programacion.getHorario_inicio(),
            programacion.getHorario_fin(),
            programacion.getDia(),
            materiaDTO,
            grupoDTO,
            aulaDTO,
            userDTO
    );
  }

  private Programacion convertToEntity(ProgramacionDTO programacionDTO) {
    Materia materia = programacionDTO.getMateriaDTO() != null ?
            new Materia(programacionDTO.getMateriaDTO().getId(), programacionDTO.getMateriaDTO().getNombre(), programacionDTO.getMateriaDTO().getSigla(), null) :
            null;
    Grupo grupo = programacionDTO.getGrupoDTO() != null ?
            new Grupo(programacionDTO.getGrupoDTO().getId(), programacionDTO.getGrupoDTO().getNombre()) :
            null;
    Aula aula = programacionDTO.getAulaDTO() != null ?
            new Aula(programacionDTO.getAulaDTO().getId(), programacionDTO.getAulaDTO().getNombre()) :
            null;
    User user = programacionDTO.getUserDTO() != null ?
            new User(programacionDTO.getUserDTO().getId(), programacionDTO.getUserDTO().getUsername(), programacionDTO.getUserDTO().getLastname(), programacionDTO.getUserDTO().getFirstname(), programacionDTO.getUserDTO().getCountry(),programacionDTO.getUserDTO().getCi(),programacionDTO.getUserDTO().getTelefono(), null) :
            null;
    return new Programacion(
            programacionDTO.getId(),
            programacionDTO.getHorario_inicio(),
            programacionDTO.getHorario_fin(),
            programacionDTO.getDia(),
            materia,
            grupo,
            aula,
            user,
            null // Asistencias no se manejan aquí
    );
  }

  /*@Transactional
  public void verificarYRegistrarFaltas() {
    LocalDateTime now = LocalDateTime.now();
    List<Asistencia> asistencias = asistenciaRepository.findByEstadoAndHorarioFinBefore(Estado.PENDIENTE, now);

    for (Asistencia asistencia : asistencias) {
      if (asistencia.getHorario_fin() == null || asistencia.getHorario_fin().isBefore(now)) {
        asistencia.setEstado(Estado.FALTA);
        asistenciaRepository.save(asistencia);
      }
    }
  }*/

}
