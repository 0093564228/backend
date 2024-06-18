package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Aula;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@RequestMapping("/api/aulas")
@RestController
@CrossOrigin/*(origins = "http://localhost:4200")*/
public class AulaController {

    private AulaService aulaService;

    @GetMapping
    public List<AulaDTO> getAllAulas() {
        return aulaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AulaDTO> getAulaById(@PathVariable Integer id) {
        Optional<AulaDTO> aulaDTO = aulaService.findById(id);
        return aulaDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<AulaDTO> createAula(@RequestBody AulaDTO aulaDTO) {
        AulaDTO savedAula = aulaService.save(aulaDTO);
        return ResponseEntity.ok(savedAula);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AulaDTO> updateAula(@PathVariable Integer id, @RequestBody AulaDTO aulaDTO) {
        aulaDTO.setId(id);
        AulaDTO updatedAula = aulaService.save(aulaDTO);
        return ResponseEntity.ok(updatedAula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAula(@PathVariable Integer id) {
        aulaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
