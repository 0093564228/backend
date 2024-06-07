package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.Materia;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.MateriaRepository;

@Service
@AllArgsConstructor
public class ProgramacionService {

    private final ProgramacionRepository programacionRepository;

    public Iterable<Programacion> getAllProgramacion() {
        return programacionRepository.findAll();
    }

    public Programacion getProgramacionById(Integer id) {
        return programacionRepository.findById(id).orElse(null);
    }

    public Programacion createProgramacion(Programacion programacion) {
        return programacionRepository.save(programacion);
    }

    public Programacion updateProgramacion(Integer id, Programacion programacion) {
        Programacion programacionToUpdate = getProgramacionById(id);
        /*programacionToUpdate.setNombre(programacion.getNombre());*/
        return programacionRepository.save(programacionToUpdate);

    }

    public void deleteProgramacion(Integer id) {
        Programacion programacionToDelete = getProgramacionById(id);
        programacionRepository.delete(programacionToDelete);
    }
}
