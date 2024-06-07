package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.Facultad;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.FacultadRepository;

@AllArgsConstructor
@Service
public class GrupoService {

    private final GrupoRepository grupoRepository;


    public Iterable<Grupo> getAllGrupos() {
        return grupoRepository.findAll();
    }

    public Grupo getGrupoById(Integer id) {
        return grupoRepository.findById(id).orElse(null);
    }

    public Grupo createGrupo(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    public Grupo updateGrupo(Integer id, Grupo grupo) {
        Grupo grupoToUpdate = getGrupoById(id);
        grupoToUpdate.setNombre(grupo.getNombre());
        return grupoRepository.save(grupoToUpdate);

    }

    public void deleteGrupo(Integer id) {
        Grupo grupoToDelete = getGrupoById(id);
        grupoRepository.delete(grupoToDelete);
    }
}
