package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Modulo_Aula;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.Facultad;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.FacultadRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AulaService {

  private AulaRepository aulaRepository;

  public List<AulaDTO> findAll() {
    List<Aula> aulas = aulaRepository.findAll();
    return aulas.stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
  }

  public Optional<AulaDTO> findById(Integer id) {
    Optional<Aula> aulaOptional = aulaRepository.findById(id);
    return aulaOptional.map(this::convertToDto);
  }

  public AulaDTO save(AulaDTO aulaDTO) {
    Aula aula = convertToEntity(aulaDTO);

    // Guardar aula y programaciones si es necesario

    aula = aulaRepository.save(aula);

    return convertToDto(aula);
  }

  public void deleteById(Integer id) {
    aulaRepository.deleteById(id);
  }

  // Método para convertir de Aula a AulaDTO
  private AulaDTO convertToDto(Aula aula) {
    return new AulaDTO(aula.getId(), aula.getNombre());
  }

  // Método para convertir de AulaDTO a Aula
  private Aula convertToEntity(AulaDTO aulaDTO) {
    return new Aula(aulaDTO.getId(), aulaDTO.getNombre(),null);
  }
}
