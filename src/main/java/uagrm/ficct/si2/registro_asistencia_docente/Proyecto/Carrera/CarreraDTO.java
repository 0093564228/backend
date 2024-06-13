package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.Facultad;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.FacultadDTO;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.Materia;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.MateriaDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarreraDTO {
  private Integer id;
  private String nombre;
  private FacultadDTO facultadDTO;
}
/*private List<MateriaDTO> materiaDTOS;*/

