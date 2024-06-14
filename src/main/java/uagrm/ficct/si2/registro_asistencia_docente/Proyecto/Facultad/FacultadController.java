package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RequestMapping("/api/facultades")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FacultadController {

  private FacultadService facultadService;

  @GetMapping
  public ResponseEntity<List<FacultadDTO>> getAll() {
    List<FacultadDTO> facultades = facultadService.findAll();
    return ResponseEntity.ok(facultades);
  }

  @GetMapping("/{id}")
  public ResponseEntity<FacultadDTO> get(@PathVariable Integer id) {
    Optional<FacultadDTO> facultadDTO = facultadService.findById(id);
    return facultadDTO.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PostMapping("/create")
  public ResponseEntity<FacultadDTO> create(@RequestBody FacultadDTO facultadDTO) {
    FacultadDTO savedFacultad = facultadService.save(facultadDTO);
    return ResponseEntity.ok(savedFacultad);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<FacultadDTO> update(@PathVariable Integer id, @RequestBody FacultadDTO facultadDTO) {
    facultadDTO.setId(id);
    FacultadDTO updatedFacultad = facultadService.update(facultadDTO);
    return ResponseEntity.ok(updatedFacultad);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    facultadService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
