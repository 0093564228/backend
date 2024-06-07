package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/api/facultades")
@RestController
public class FacultadController {

    private final FacultadService facultadService;

    @GetMapping
    public Iterable<Facultad> list() {
        return facultadService.getAllFacultades();
    }

    @GetMapping("{id}")
    public Facultad get(@PathVariable Integer id) {
        return facultadService.getFacultadById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Facultad create(@RequestBody Facultad facultad) {
        return facultadService.createFacultad(facultad);
    }

    @PutMapping("update/{id}")
    public Facultad update(@PathVariable Integer id,
                           @RequestBody Facultad facultad) {
        return facultadService.updateFacultad(id, facultad);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        facultadService.deleteFacultad(id);
    }
}
