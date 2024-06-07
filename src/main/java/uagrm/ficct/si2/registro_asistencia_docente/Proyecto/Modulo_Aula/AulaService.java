package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Modulo_Aula;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.Facultad;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.FacultadRepository;

@AllArgsConstructor
@Service
public class AulaService {

    private final AulaRepository aulaRepository;


    public Iterable<Aula> getAllAulas() {
        return aulaRepository.findAll();
    }

    public Aula getAulaById(Integer id) {
        return aulaRepository.findById(id).orElse(null);
    }

    public Aula createAula(Aula facultad) {
        return aulaRepository.save(facultad);
    }

    public Aula updateAula(Integer id, Aula aula) {
        Aula aulaToUpdate = getAulaById(id);
        aulaToUpdate.setNombre(aula.getNombre());
        return aulaRepository.save(aulaToUpdate);
    }

    public void deleteAula(Integer id) {
        Aula aulaToDelete = getAulaById(id);
        aulaRepository.delete(aulaToDelete);
    }
}
