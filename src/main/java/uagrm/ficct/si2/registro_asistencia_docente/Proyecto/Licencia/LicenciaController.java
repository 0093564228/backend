package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Licencia;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion.ProgramacionDTO;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RequestMapping("/api/licencias")
@RestController
/*@CrossOrigin*//*(origins = "http://localhost:4200")*/
public class LicenciaController {

  private LicenciaService licenciaService;

  @GetMapping
  public ResponseEntity<List<LicenciaDTO>> getAllLicencias() {
    List<LicenciaDTO> licencias = licenciaService.findAll();
    return ResponseEntity.ok(licencias);
  }

  @GetMapping("/{id}")
  public ResponseEntity<LicenciaDTO> getLicenciaById(@PathVariable Integer id) {
    Optional<LicenciaDTO> licencia = licenciaService.findById(id);
    return licencia.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping("/create")
  public ResponseEntity<LicenciaDTO> createLicencia(@RequestBody LicenciaDTO licenciaDTO) {
    LicenciaDTO createdLicencia = licenciaService.save(licenciaDTO);
    return new ResponseEntity<>(createdLicencia, HttpStatus.CREATED);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<LicenciaDTO> updateLicencia(@PathVariable Integer id, @RequestBody LicenciaDTO licenciaDTO) {
    LicenciaDTO updatedLicencia = licenciaService.update(id, licenciaDTO);
    return ResponseEntity.ok(updatedLicencia);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteLicencia(@PathVariable Integer id) {
    licenciaService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
