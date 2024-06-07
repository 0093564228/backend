package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.Facultad;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.FacultadService;

@AllArgsConstructor
@RequestMapping("/api/grupos")
@RestController
public class GrupoController {

    private final GrupoService grupoService;

    @GetMapping
    public Iterable<Grupo> list() {
        return grupoService.getAllGrupos();
    }

    @GetMapping("{id}")
    public Grupo get(@PathVariable Integer id) {
        return grupoService.getGrupoById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Grupo create(@RequestBody Grupo grupo) {
        return grupoService.createGrupo(grupo);
    }

    @PutMapping("update/{id}")
    public Grupo update(@PathVariable Integer id,
                           @RequestBody Grupo grupo) {
        return grupoService.updateGrupo(id, grupo);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        grupoService.deleteGrupo(id);
    }

}
