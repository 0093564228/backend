package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RequestMapping("/api/carreras")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CarreraController {

  private CarreraService carreraService;

  @GetMapping
  public ResponseEntity<List<CarreraDTO>> getAll() {
    List<CarreraDTO> carreras = carreraService.findAll();
    return ResponseEntity.ok(carreras);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CarreraDTO> get(@PathVariable Integer id) {
    Optional<CarreraDTO> carreraDTO = carreraService.findById(id);
    return carreraDTO.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PostMapping("/create")
  public ResponseEntity<CarreraDTO> create(@RequestBody CarreraDTO carreraDTO) {
    CarreraDTO savedCarrera = carreraService.save(carreraDTO);
    return ResponseEntity.ok(savedCarrera);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<CarreraDTO> update(@PathVariable Integer id, @RequestBody CarreraDTO carreraDTO) {
    try {
      CarreraDTO updatedCarrera = carreraService.update(id, carreraDTO);
      return ResponseEntity.ok(updatedCarrera);
    } catch (EntityNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    carreraService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
