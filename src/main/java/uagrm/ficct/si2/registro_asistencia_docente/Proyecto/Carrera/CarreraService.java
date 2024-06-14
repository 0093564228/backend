package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.Facultad;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.FacultadDTO;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.FacultadRepository;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.FacultadService;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.Materia;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.MateriaDTO;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.MateriaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarreraService {

  private CarreraRepository carreraRepository;

  @Autowired
  private FacultadRepository facultadRepository;

  public List<CarreraDTO> findAll() {
    return carreraRepository.findAll().stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
  }

  public Optional<CarreraDTO> findById(Integer id) {
    return carreraRepository.findById(id).map(this::convertToDto);
  }

  public CarreraDTO save(CarreraDTO carreraDTO) {
    Carrera carrera = convertToEntity(carreraDTO);
    carrera = carreraRepository.save(carrera);
    return convertToDto(carrera);
  }

  public void deleteById(Integer id) {
    carreraRepository.deleteById(id);
  }

  public CarreraDTO update(Integer id, CarreraDTO carreraDTO) {
    if (carreraRepository.existsById(id)) {
      Carrera carrera = convertToEntity(carreraDTO);
      carrera.setId(id); // Asegurar que el ID sea el correcto
      carrera = carreraRepository.save(carrera);
      return convertToDto(carrera);
    } else {
      throw new EntityNotFoundException("Carrera not found with id " + id);
    }
  }

  private CarreraDTO convertToDto(Carrera carrera) {
    FacultadDTO facultadDTO = new FacultadDTO(carrera.getFacultad().getId(), carrera.getFacultad().getNombre(), carrera.getFacultad().getModulo());
    return new CarreraDTO(carrera.getId(), carrera.getNombre(), facultadDTO);
  }

  private Carrera convertToEntity(CarreraDTO carreraDTO) {
    Optional<Facultad> facultadOptional = facultadRepository.findById(carreraDTO.getFacultadDTO().getId());
    if (facultadOptional.isEmpty()) {
      throw new EntityNotFoundException("Facultad not found with id " + carreraDTO.getFacultadDTO().getId());
    }
    Facultad facultad = facultadOptional.get();
    return new Carrera(carreraDTO.getId(), carreraDTO.getNombre(), facultad, null);
  }
}
