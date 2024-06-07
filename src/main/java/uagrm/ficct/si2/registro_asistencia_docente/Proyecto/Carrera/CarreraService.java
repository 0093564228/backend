package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarreraService {


    private final CarreraRepository carreraRepository;


    public Iterable<Carrera> getAllCarreras() {
        return carreraRepository.findAll();
    }

    public Carrera getCarreraById(Integer id) {
        return carreraRepository.findById(id).orElse(null);
    }

    public Carrera createCarrera(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    public Carrera updateCarrera(Integer id, Carrera carrera) {
        Carrera carreraToUpdate = getCarreraById(id);

        carreraToUpdate.setNombre(carrera.getNombre());


        return carreraRepository.save(carreraToUpdate);

    }

    public void deleteCarrera(Integer id) {
        Carrera carreraToDelete = getCarreraById(id);
        carreraRepository.delete(carreraToDelete);
    }
}
