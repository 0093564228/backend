package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.Carrera;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.CarreraService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RequestMapping("/api/materias")
@RestController
@CrossOrigin/*(origins = "http://localhost:4200")*/
public class MateriaController {
  private MateriaService materiaService;

  @GetMapping
  public ResponseEntity<List<MateriaDTO>> getAll() {
    List<MateriaDTO> materias = materiaService.findAll();
    return ResponseEntity.ok(materias);
  }

  @GetMapping("/{id}")
  public ResponseEntity<MateriaDTO> get(@PathVariable Integer id) {
    Optional<MateriaDTO> materiaDTO = materiaService.findById(id);
    return materiaDTO.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PostMapping("/create")
  public ResponseEntity<MateriaDTO> create(@RequestBody MateriaDTO materiaDTO) {
    MateriaDTO savedMateria = materiaService.save(materiaDTO);
    return ResponseEntity.ok(savedMateria);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<MateriaDTO> update(@PathVariable Integer id, @RequestBody MateriaDTO materiaDTO) {
    try {
      MateriaDTO updatedMateria = materiaService.update(id, materiaDTO);
      return ResponseEntity.ok(updatedMateria);
    } catch (EntityNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    materiaService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
