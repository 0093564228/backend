package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Modulo_Aula;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.Facultad;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.FacultadService;


@AllArgsConstructor
@RequestMapping("/api/aulas")
@RestController
public class AulaController {

    private final AulaService aulaService;

    @GetMapping
    public Iterable<Aula> list() {
        return aulaService.getAllAulas();
    }

    @GetMapping("{id}")
    public Aula get(@PathVariable Integer id) {
        return aulaService.getAulaById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Aula create(@RequestBody Aula aula) {
        return aulaService.createAula(aula);
    }

    @PutMapping("update/{id}")
    public Aula update(@PathVariable Integer id,
                       @RequestBody Aula aula) {
        return aulaService.updateAula(id, aula);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        aulaService.deleteAula(id);
    }
}
