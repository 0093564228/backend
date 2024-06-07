package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.Materia;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.MateriaService;

@AllArgsConstructor
@RequestMapping("/api/programacion")
@RestController
public class ProgramacionController {

    private final ProgramacionService programacionService;

    @GetMapping
    public Iterable<Programacion> list() {
        return programacionService.getAllProgramacion();
    }

    @GetMapping("{id}")
    public Programacion get(@PathVariable Integer id) {
        return programacionService.getProgramacionById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Programacion create(@RequestBody Programacion programacion) {
        return  programacionService.createProgramacion(programacion);
    }

    @PutMapping("update/{id}")
    public Programacion update(@PathVariable Integer id,
                          @RequestBody Programacion programacion) {
        return  programacionService.updateProgramacion(id,programacion);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        programacionService.deleteProgramacion(id);
    }
}
