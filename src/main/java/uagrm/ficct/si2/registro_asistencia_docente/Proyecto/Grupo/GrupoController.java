package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.Facultad;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.FacultadService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RequestMapping("/api/grupos")
@RestController
public class GrupoController {

    private GrupoService grupoService;

    @GetMapping
    public List<GrupoDTO> getAllGrupos() {
        return grupoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoDTO> getGrupoById(@PathVariable Integer id) {
        Optional<GrupoDTO> grupoDTO = grupoService.findById(id);
        return grupoDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<GrupoDTO> createGrupo(@RequestBody GrupoDTO grupoDTO) {
        GrupoDTO savedGrupo = grupoService.save(grupoDTO);
        return ResponseEntity.ok(savedGrupo);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<GrupoDTO> updateGrupo(@PathVariable Integer id, @RequestBody GrupoDTO grupoDTO) {
        grupoDTO.setId(id);
        GrupoDTO updatedGrupo = grupoService.save(grupoDTO);
        return ResponseEntity.ok(updatedGrupo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrupo(@PathVariable Integer id) {
        grupoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
