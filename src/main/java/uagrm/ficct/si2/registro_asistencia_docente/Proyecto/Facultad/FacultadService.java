package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.Carrera;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.CarreraRepository;

@AllArgsConstructor
@Service
public class FacultadService {

    private final FacultadRepository facultadRepository;

    public Iterable<Facultad> getAllFacultades() {
        return facultadRepository.findAll();
    }

    public Facultad getFacultadById(Integer id) {
        return facultadRepository.findById(id).orElse(null);
    }

    public Facultad createFacultad(Facultad facultad) {
        return facultadRepository.save(facultad);
    }

    public Facultad updateFacultad(Integer id, Facultad facultad) {
        Facultad facultadToUpdate = getFacultadById(id);
        facultadToUpdate.setNombre(facultad.getNombre());
        return facultadRepository.save(facultadToUpdate);
    }

    public void deleteFacultad(Integer id) {
        Facultad facultadToDelete = getFacultadById(id);
        facultadRepository.delete(facultadToDelete);
    }
}
