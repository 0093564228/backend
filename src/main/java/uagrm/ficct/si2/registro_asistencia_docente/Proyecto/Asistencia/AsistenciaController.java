package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Asistencia;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.CarreraDTO;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.CarreraService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RequestMapping("/api/asistencias")
@RestController
public class AsistenciaController {
  private AsistenciaService asistenciaService;

  @GetMapping
  public ResponseEntity<List<AsistenciaDTO>> getAllAsistencias() {
    List<AsistenciaDTO> asistencias = asistenciaService.findAll();
    return ResponseEntity.ok(asistencias);
  }

  @GetMapping("/{id}")
  public ResponseEntity<AsistenciaDTO> getAsistenciaById(@PathVariable Integer id) {
    Optional<AsistenciaDTO> asistencia = asistenciaService.findById(id);
    return asistencia.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping("/create")
  public ResponseEntity<AsistenciaDTO> createAsistencia(@RequestBody AsistenciaDTO asistenciaDTO) {
    AsistenciaDTO createdAsistencia = asistenciaService.save(asistenciaDTO);
    return new ResponseEntity<>(createdAsistencia, HttpStatus.CREATED);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<AsistenciaDTO> updateAsistencia(@PathVariable Integer id, @RequestBody AsistenciaDTO asistenciaDTO) {
    AsistenciaDTO updatedAsistencia = asistenciaService.update(id, asistenciaDTO);
    return ResponseEntity.ok(updatedAsistencia);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAsistencia(@PathVariable Integer id) {
    asistenciaService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
