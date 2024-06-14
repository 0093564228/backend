package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.Materia;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.MateriaService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RequestMapping("/api/programacion")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProgramacionController {

  private ProgramacionService programacionService;

  // Endpoint para obtener todas las programaciones
  @GetMapping
  public ResponseEntity<List<ProgramacionDTO>> getAllProgramaciones() {
    List<ProgramacionDTO> programaciones = programacionService.findAll();
    return ResponseEntity.ok(programaciones);
  }

  // Endpoint para obtener una programación por su ID
  @GetMapping("/{id}")
  public ResponseEntity<ProgramacionDTO> getProgramacionById(@PathVariable Integer id) {
    Optional<ProgramacionDTO> programacion = programacionService.findById(id);
    return programacion.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  // Endpoint para crear una nueva programación
  @PostMapping("/create")
  public ResponseEntity<ProgramacionDTO> createProgramacion(@RequestBody ProgramacionDTO programacionDTO) {
    ProgramacionDTO createdProgramacion = programacionService.save(programacionDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdProgramacion);
  }

  // Endpoint para actualizar una programación existente
  @PutMapping("/update/{id}")
  public ResponseEntity<ProgramacionDTO> updateProgramacion(@PathVariable Integer id, @RequestBody ProgramacionDTO programacionDTO) {
    programacionDTO.setId(id); // aseguramos que el ID coincida con el path variable
    ProgramacionDTO updatedProgramacion = programacionService.save(programacionDTO);
    return ResponseEntity.ok(updatedProgramacion);
  }

  // Endpoint para eliminar una programación por su ID
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProgramacion(@PathVariable Integer id) {
    programacionService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
