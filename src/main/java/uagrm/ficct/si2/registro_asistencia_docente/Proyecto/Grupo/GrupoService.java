package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.Facultad;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.FacultadRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class GrupoService {

    private GrupoRepository grupoRepository;

    public List<GrupoDTO> findAll() {
        List<Grupo> grupos = grupoRepository.findAll();
        return grupos.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<GrupoDTO> findById(Integer id) {
        Optional<Grupo> grupoOptional = grupoRepository.findById(id);
        return grupoOptional.map(this::convertToDto);
    }

    public GrupoDTO save(GrupoDTO grupoDTO) {
        Grupo grupo = convertToEntity(grupoDTO);

        // Guardar grupo y programaciones si es necesario

        grupo = grupoRepository.save(grupo);

        return convertToDto(grupo);
    }

    public void deleteById(Integer id) {
        grupoRepository.deleteById(id);
    }

    // Método para convertir de Grupo a GrupoDTO
    private GrupoDTO convertToDto(Grupo grupo) {
        return new GrupoDTO(grupo.getId(), grupo.getNombre());
    }

    // Método para convertir de GrupoDTO a Grupo
    private Grupo convertToEntity(GrupoDTO grupoDTO) {
        return new Grupo(grupoDTO.getId(), grupoDTO.getNombre(),null);
    }
}
