package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/api/carreras")
@RestController
public class CarreraController {

    private final CarreraService carreraService;

    @GetMapping
    public Iterable<Carrera> list() {
        return carreraService.getAllCarreras();
    }

    @GetMapping("{id}")
    public Carrera get(@PathVariable Integer id) {
        return carreraService.getCarreraById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Carrera create(@RequestBody Carrera carrera) {
        return carreraService.createCarrera(carrera);
    }

    @PutMapping("update/{id}")
    public Carrera update(@PathVariable Integer id,
                          @RequestBody Carrera carrera) {
        return carreraService.updateCarrera(id, carrera);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        carreraService.deleteCarrera(id);
    }
}
