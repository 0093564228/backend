package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.Carrera;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.CarreraService;

@AllArgsConstructor
@RequestMapping("/api/materias")
@RestController
public class MateriaController {
    private final MateriaService materiaService;

    @GetMapping
    public Iterable<Materia> list() {
        return materiaService.getAllMateria();
    }

    @GetMapping("{id}")
    public Materia get(@PathVariable Integer id) {
        return materiaService.getMateriaById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Materia create(@RequestBody Materia materia) {
        return  materiaService.createMateria(materia);
    }

    @PutMapping("update/{id}")
    public Materia update(@PathVariable Integer id,
                          @RequestBody Materia materia) {
        return  materiaService.updateMateria(id,materia);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        materiaService.deleteMateria(id);
    }
}
