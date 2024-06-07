package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.Carrera;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.CarreraRepository;

@Service
@AllArgsConstructor
public class MateriaService {

    private final MateriaRepository materiaRepository;

    public Iterable<Materia> getAllMateria() {
        return materiaRepository.findAll();
    }

    public Materia getMateriaById(Integer id) {
        return materiaRepository.findById(id).orElse(null);
    }

    public Materia createMateria(Materia materia) {
        return materiaRepository.save(materia);
    }

    public Materia updateMateria(Integer id, Materia materia) {
        Materia materiaToUpdate = getMateriaById(id);
        materiaToUpdate.setNombre(materia.getNombre());
        return materiaRepository.save(materiaToUpdate);

    }

    public void deleteMateria(Integer id) {
        Materia materiaToDelete = getMateriaById(id);
        materiaRepository.delete(materiaToDelete);
    }
}
