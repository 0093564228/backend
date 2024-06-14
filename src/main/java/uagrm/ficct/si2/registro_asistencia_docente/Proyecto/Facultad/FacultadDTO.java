package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.CarreraDTO;

import java.util.Calendar;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultadDTO {
  private Integer id;
  private String nombre;
  private String modulo;
}
/*private List<CarreraDTO> carreraDTOs;*/