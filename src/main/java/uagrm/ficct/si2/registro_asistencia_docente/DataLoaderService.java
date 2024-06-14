package uagrm.ficct.si2.registro_asistencia_docente;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Asistencia.Asistencia;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Asistencia.AsistenciaRepository;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.Carrera;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.CarreraRepository;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.Facultad;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.FacultadRepository;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo.Grupo;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo.GrupoRepository;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Licencia.Licencia;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Licencia.LicenciaRepository;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.Materia;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.MateriaRepository;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Aula.Aula;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Aula.AulaRepository;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion.Dia;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion.Programacion;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion.ProgramacionRepository;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Usuario.UsuarioRepository;
import uagrm.ficct.si2.registro_asistencia_docente.User.Role;
import uagrm.ficct.si2.registro_asistencia_docente.User.User;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class DataLoaderService {

  @Autowired
  private FacultadRepository facultadRepository;

  @Autowired
  private CarreraRepository carreraRepository;

  @Autowired
  private MateriaRepository materiaRepository;

  @Autowired
  private AulaRepository aulaRepository;

  @Autowired
  private GrupoRepository grupoRepository;

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Autowired
  private ProgramacionRepository programacionRepository;

  @Autowired
  private AsistenciaRepository asistenciaRepository;

  @Autowired
  private LicenciaRepository licenciaRepository;


  public void loadData() {

    /*---------------------------------------------------------------------------------------------------------------------*/
    Facultad facultad1 = new Facultad(1, "Facultad de ingeniería en ciencias de la computación y telecomunicaciones", "236", null);
    Facultad facultad2 = new Facultad(2, "Facultad de ciencias exactas y naturales", "226", null);
    facultadRepository.save(facultad1);
    facultadRepository.save(facultad2);
    /*---------------------------------------------------------------------------------------------------------------------*/
    Carrera carrera1 = new Carrera(1, "Ingeniería en Sistemas", facultad1, null);
    Carrera carrera2 = new Carrera(2, "Ingeniería en Informática", facultad1, null);
    Carrera carrera3 = new Carrera(3, "Ingeniería en Telecomunicaciones", facultad1, null);
    carreraRepository.save(carrera1);
    carreraRepository.save(carrera2);
    carreraRepository.save(carrera3);
    /*---------------------------------------------------------------------------------------------------------------------*/
    Materia materia1 = new Materia(1, "Programación I", "PROG1", carrera1, null);
    Materia materia8 = new Materia(2, "Programación II", "PROG2", carrera2, null);
    Materia materia2 = new Materia(3, "Estructuras de Datos I", "ED", carrera1, null);
    Materia materia7 = new Materia(4, "Estructuras de Datos I", "ED", carrera3, null);
    Materia materia9 = new Materia(5, "Bases de Datos II", "BD", carrera1, null);
    Materia materia3 = new Materia(5, "Bases de Datos I", "BD", carrera1, null);
    Materia materia4 = new Materia(6, "Sistemas Operativos I", "SO", carrera2, null);
    Materia materia5 = new Materia(7, "Redes I", "RED", carrera2, null);
    Materia materia6 = new Materia(8, "Programación II", "PROG2", carrera2, null);
    Materia materia10 = new Materia(9, "Introducción a la informatica", "INTRO", carrera1, null);
    Materia materia11 = new Materia(10, "Introducción a la informatica", "INTRO", carrera2, null);
    Materia materia12 = new Materia(11, "Introducción a la informatica", "INTRO", carrera3, null);
    Materia materia13 = new Materia(12, "Ingles I", "LIN100", carrera1, null);
    Materia materia14 = new Materia(13, "Ingles I", "LIN100", carrera2, null);
    Materia materia15 = new Materia(14, "Ingles I", "LIN100", carrera3, null);
    materiaRepository.save(materia1);
    materiaRepository.save(materia2);
    materiaRepository.save(materia3);
    materiaRepository.save(materia4);
    materiaRepository.save(materia5);
    materiaRepository.save(materia6);
    materiaRepository.save(materia7);
    materiaRepository.save(materia8);
    materiaRepository.save(materia9);
    materiaRepository.save(materia10);
    materiaRepository.save(materia11);
    materiaRepository.save(materia12);
    materiaRepository.save(materia13);
    materiaRepository.save(materia14);
    materiaRepository.save(materia15);
    /*---------------------------------------------------------------------------------------------------------------------*/
    Aula aula1 = new Aula(1, "15", null);
    Aula aula2 = new Aula(2, "16", null);
    Aula aula4 = new Aula(3, "17", null);
    Aula aula5 = new Aula(4, "20", null);
    Aula aula6 = new Aula(5, "30", null);
    Aula aula7 = new Aula(6, "35", null);
    Aula aula8 = new Aula(7, "45", null);
    Aula aula9 = new Aula(8, "46", null);
    Aula aula10 = new Aula(9, "47", null);
    aulaRepository.save(aula1);
    aulaRepository.save(aula2);
    aulaRepository.save(aula4);
    aulaRepository.save(aula5);
    aulaRepository.save(aula6);
    aulaRepository.save(aula7);
    aulaRepository.save(aula8);
    aulaRepository.save(aula9);
    aulaRepository.save(aula10);
    /*---------------------------------------------------------------------------------------------------------------------*/
    Grupo grupo1 = new Grupo(1, "Z1", null);
    Grupo grupo2 = new Grupo(2, "Z2", null);
    Grupo grupo3 = new Grupo(3, "Z3", null);
    Grupo grupo4 = new Grupo(4, "Z4", null);
    Grupo grupo5 = new Grupo(5, "Z5", null);
    Grupo grupo6 = new Grupo(6, "SA", null);
    Grupo grupo7 = new Grupo(7, "SB", null);
    Grupo grupo8 = new Grupo(8, "SC", null);
    Grupo grupo9 = new Grupo(9, "B1", null);
    Grupo grupo10 = new Grupo(10, "B2", null);
    Grupo grupo11 = new Grupo(11, "B3", null);
    grupoRepository.save(grupo1);
    grupoRepository.save(grupo2);
    grupoRepository.save(grupo3);
    grupoRepository.save(grupo4);
    grupoRepository.save(grupo5);
    grupoRepository.save(grupo6);
    grupoRepository.save(grupo7);
    grupoRepository.save(grupo8);
    grupoRepository.save(grupo9);
    grupoRepository.save(grupo10);
    grupoRepository.save(grupo11);
    ;
    /*---------------------------------------------------------------------------------------------------------------------*/
    User docente1 = new User(1, "docente1@gmail.com", "Carriazo", "Raul", "SC", "12345678", Role.USER, null, null);
    User docente2 = new User(2, "docente2@gmail.com", "Gutierres", "Pablo", "SC", "12345678", Role.USER, null, null);
    User docente3 = new User(3, "docente3@gmail.com", "Obando", "Luis", "SC", "12345678", Role.USER, null, null);
    User docente4 = new User(4, "docente4@gmail.com", "Quintana", "Roberto", "SC", "12345678", Role.USER, null, null);
    User admin1 = new User(5, "admin1@gmail.com", "López", "Abel", "SC", "12345678", Role.ADMIN, null, null);
    User admin2 = new User(6, "admin2@gmail.com", "Vaca", "Priscila", "SC", "12345678", Role.ADMIN, null, null);
    usuarioRepository.save(docente1);
    usuarioRepository.save(docente2);
    usuarioRepository.save(docente3);
    usuarioRepository.save(docente4);
    usuarioRepository.save(admin1);
    usuarioRepository.save(admin2);
    /*---------------------------------------------------------------------------------------------------------------------*/


    /*LocalDateTime horario_inicio1 = LocalDateTime.of(2024, 6, 14, 3, 0, 0);
    LocalDateTime horario_fin1 = LocalDateTime.of(2024, 6, 14, 5, 15);

    System.out.println("horario_inicio1: " + horario_inicio1);
    System.out.println("horario_inicio1: " + horario_fin1);*/

    /*programacion para docente1 para un mes , dias martes y jueves, 2hrs 15min*/
    Programacion programacion1 = new Programacion(1, LocalDateTime.of(2024, 6, 11, 3, 0, 0), LocalDateTime.of(2024, 6, 11, 5, 15), Dia.MARTES, materia7, grupo1, aula1, docente1, null);
    Programacion programacion2 = new Programacion(2, LocalDateTime.of(2024, 6, 13, 3, 0, 0), LocalDateTime.of(2024, 6, 13, 5, 15), Dia.JUEVES, materia7, grupo1, aula1, docente1, null);
    Programacion programacion3 = new Programacion(3, LocalDateTime.of(2024, 6, 18, 3, 0, 0), LocalDateTime.of(2024, 6, 18, 5, 15), Dia.MARTES, materia7, grupo1, aula1, docente1, null);
    Programacion programacion4 = new Programacion(4, LocalDateTime.of(2024, 6, 20, 3, 0, 0), LocalDateTime.of(2024, 6, 20, 5, 15), Dia.JUEVES, materia7, grupo1, aula1, docente1, null);
    Programacion programacion5 = new Programacion(5, LocalDateTime.of(2024, 6, 25, 3, 0, 0), LocalDateTime.of(2024, 6, 25, 5, 15), Dia.MARTES, materia7, grupo1, aula1, docente1, null);
    Programacion programacion6 = new Programacion(6, LocalDateTime.of(2024, 6, 27, 3, 0, 0), LocalDateTime.of(2024, 6, 27, 5, 15), Dia.JUEVES, materia7, grupo1, aula1, docente1, null);
    Programacion programacion7 = new Programacion(7, LocalDateTime.of(2024, 7, 2, 3, 0, 0), LocalDateTime.of(2024, 7, 2, 5, 15), Dia.MARTES, materia7, grupo1, aula1, docente1, null);
    Programacion programacion8 = new Programacion(8, LocalDateTime.of(2024, 7, 4, 3, 0, 0), LocalDateTime.of(2024, 7, 4, 5, 15), Dia.JUEVES, materia7, grupo1, aula1, docente1, null);
    /*programacion para docente2 para un mes , dias lunes miercoles viernes , 1hr 30min*/
    Programacion programacion9 = new Programacion(9, LocalDateTime.of(2024, 6, 10, 3, 0, 0), LocalDateTime.of(2024, 6, 10, 4, 30), Dia.LUNES, materia3, grupo2, aula2, docente2, null);
    Programacion programacion10 = new Programacion(10, LocalDateTime.of(2024, 6, 12, 3, 0, 0), LocalDateTime.of(2024, 6, 12, 4, 30), Dia.MARTES, materia3, grupo2, aula2, docente2, null);
    Programacion programacion11 = new Programacion(11, LocalDateTime.of(2024, 6, 14, 3, 0, 0), LocalDateTime.of(2024, 6, 14, 4, 30), Dia.MIERCOLES, materia3, grupo2, aula2, docente2, null);
    Programacion programacion12 = new Programacion(12, LocalDateTime.of(2024, 6, 17, 3, 0, 0), LocalDateTime.of(2024, 6, 17, 4, 30), Dia.LUNES, materia3, grupo2, aula2, docente2, null);
    Programacion programacion13 = new Programacion(13, LocalDateTime.of(2024, 6, 19, 3, 0, 0), LocalDateTime.of(2024, 6, 19, 4, 30), Dia.MARTES, materia3, grupo2, aula2, docente2, null);
    Programacion programacion14 = new Programacion(14, LocalDateTime.of(2024, 6, 21, 3, 0, 0), LocalDateTime.of(2024, 6, 21, 4, 30), Dia.MIERCOLES, materia3, grupo2, aula2, docente2, null);
    Programacion programacion15 = new Programacion(15, LocalDateTime.of(2024, 6, 24, 3, 0, 0), LocalDateTime.of(2024, 6, 24, 4, 30), Dia.LUNES, materia3, grupo2, aula2, docente2, null);
    Programacion programacion16 = new Programacion(16, LocalDateTime.of(2024, 6, 26, 3, 0, 0), LocalDateTime.of(2024, 6, 26, 4, 30), Dia.MARTES, materia3, grupo2, aula2, docente2, null);
    Programacion programacion17 = new Programacion(17, LocalDateTime.of(2024, 6, 28, 3, 0, 0), LocalDateTime.of(2024, 6, 28, 4, 30), Dia.MIERCOLES, materia3, grupo2, aula2, docente2, null);
    Programacion programacion18 = new Programacion(18, LocalDateTime.of(2024, 7, 1, 3, 0, 0), LocalDateTime.of(2024, 7, 1, 4, 30), Dia.LUNES, materia3, grupo2, aula2, docente2, null);
    Programacion programacion19 = new Programacion(19, LocalDateTime.of(2024, 7, 3, 3, 0, 0), LocalDateTime.of(2024, 7, 3, 4, 30), Dia.MARTES, materia3, grupo2, aula2, docente2, null);
    Programacion programacion20 = new Programacion(20, LocalDateTime.of(2024, 7, 5, 3, 0, 0), LocalDateTime.of(2024, 7, 5, 4, 30), Dia.MIERCOLES, materia3, grupo2, aula2, docente2, null);

    programacionRepository.save(programacion1);
    programacionRepository.save(programacion2);
    programacionRepository.save(programacion3);
    programacionRepository.save(programacion4);
    programacionRepository.save(programacion5);
    programacionRepository.save(programacion6);
    programacionRepository.save(programacion7);
    programacionRepository.save(programacion8);
    programacionRepository.save(programacion9);
    programacionRepository.save(programacion10);
    programacionRepository.save(programacion11);
    programacionRepository.save(programacion12);
    programacionRepository.save(programacion13);
    programacionRepository.save(programacion14);
    programacionRepository.save(programacion15);
    programacionRepository.save(programacion16);
    programacionRepository.save(programacion17);
    programacionRepository.save(programacion18);
    programacionRepository.save(programacion19);
    programacionRepository.save(programacion20);
    /*---------------------------------------------------------------------------------------------------------------------*/
    Licencia licencia1 = new Licencia(1, LocalDateTime.of(2024, 6, 11, 0, 0), LocalDateTime.of(2024, 7, 4, 0, 0), "Vacaciones", docente3);
    Licencia licencia2 = new Licencia(2, LocalDateTime.of(2024, 6, 10, 0, 0), LocalDateTime.of(2024, 7, 5, 0, 0), "Cirugia", docente4);

    licenciaRepository.save(licencia1);
    licenciaRepository.save(licencia2);
    /*---------------------------------------------------------------------------------------------------------------------*/

    Asistencia asistencia1 = new Asistencia(1, LocalDateTime.of(2024, 6, 11, 3, 0, 0), LocalDateTime.of(2024, 6, 11, 5, 15), "Presente", programacion1);
    Asistencia asistencia2 = new Asistencia(2, LocalDateTime.of(2024, 6, 13, 3, 0, 0), LocalDateTime.of(2024, 6, 13, 5, 15), "Presente", programacion2);
    Asistencia asistencia3 = new Asistencia(3, LocalDateTime.of(2024, 6, 18, 3, 0, 0), LocalDateTime.of(2024, 6, 18, 5, 15), "Presente", programacion3);
    Asistencia asistencia4 = new Asistencia(4, LocalDateTime.of(2024, 6, 20, 3, 0, 0), LocalDateTime.of(2024, 6, 20, 5, 15), "Presente", programacion4);
    Asistencia asistencia5 = new Asistencia(5, LocalDateTime.of(2024, 6, 25, 3, 0, 0), LocalDateTime.of(2024, 6, 25, 5, 15), "Presente", programacion5);
    Asistencia asistencia6 = new Asistencia(6, LocalDateTime.of(2024, 6, 27, 3, 0, 0), LocalDateTime.of(2024, 6, 27, 5, 15), "Presente", programacion6);
    Asistencia asistencia7 = new Asistencia(7, LocalDateTime.of(2024, 7, 2, 3, 0, 0), LocalDateTime.of(2024, 7, 2, 5, 15), "Presente", programacion7);
    Asistencia asistencia8 = new Asistencia(8, LocalDateTime.of(2024, 7, 4, 3, 0, 0), LocalDateTime.of(2024, 7, 4, 5, 15), "Presente", programacion8);


    Asistencia asistencia9 = new Asistencia(9, LocalDateTime.of(2024, 6, 10, 3, 0, 0), LocalDateTime.of(2024, 6, 10, 4, 30), "Presente", programacion9);
    Asistencia asistencia10 = new Asistencia(10, LocalDateTime.of(2024, 6, 12, 3, 0, 0), LocalDateTime.of(2024, 6, 12, 4, 30), "Presente", programacion10);
    Asistencia asistencia11 = new Asistencia(11, LocalDateTime.of(2024, 6, 14, 3, 0, 0), LocalDateTime.of(2024, 6, 14, 4, 30), "Presente", programacion11);
    Asistencia asistencia12 = new Asistencia(12, LocalDateTime.of(2024, 6, 17, 3, 0, 0), LocalDateTime.of(2024, 6, 17, 4, 30), "Presente", programacion12);
    Asistencia asistencia13 = new Asistencia(13, LocalDateTime.of(2024, 6, 19, 3, 0, 0), LocalDateTime.of(2024, 6, 19, 4, 30), "Presente", programacion13);
    Asistencia asistencia14 = new Asistencia(14, LocalDateTime.of(2024, 6, 21, 3, 0, 0), LocalDateTime.of(2024, 6, 21, 4, 30), "Presente", programacion14);
    Asistencia asistencia15 = new Asistencia(15, LocalDateTime.of(2024, 6, 24, 3, 0, 0), LocalDateTime.of(2024, 6, 24, 4, 30), "Presente", programacion15);
    Asistencia asistencia16 = new Asistencia(16, LocalDateTime.of(2024, 6, 26, 3, 0, 0), LocalDateTime.of(2024, 6, 26, 4, 30), "Presente", programacion16);
    Asistencia asistencia17 = new Asistencia(17, LocalDateTime.of(2024, 6, 28, 3, 0, 0), LocalDateTime.of(2024, 6, 28, 4, 30), "Presente", programacion17);
    Asistencia asistencia18 = new Asistencia(18, LocalDateTime.of(2024, 7, 1, 3, 0, 0), LocalDateTime.of(2024, 7, 1, 4, 30), "Presente", programacion18);
    Asistencia asistencia19 = new Asistencia(19, LocalDateTime.of(2024, 7, 3, 3, 0, 0), LocalDateTime.of(2024, 7, 3, 4, 30), "Presente", programacion19);
    Asistencia asistencia20 = new Asistencia(20, LocalDateTime.of(2024, 7, 5, 3, 0, 0), LocalDateTime.of(2024, 7, 5, 4, 30), "Presente", programacion20);
    asistenciaRepository.save(asistencia1);
    asistenciaRepository.save(asistencia2);
    asistenciaRepository.save(asistencia3);
    asistenciaRepository.save(asistencia4);
    asistenciaRepository.save(asistencia5);
    asistenciaRepository.save(asistencia6);
    asistenciaRepository.save(asistencia7);
    asistenciaRepository.save(asistencia8);
    asistenciaRepository.save(asistencia9);
    asistenciaRepository.save(asistencia10);
    asistenciaRepository.save(asistencia11);
    asistenciaRepository.save(asistencia12);
    asistenciaRepository.save(asistencia13);
    asistenciaRepository.save(asistencia14);
    asistenciaRepository.save(asistencia15);
    asistenciaRepository.save(asistencia16);
    asistenciaRepository.save(asistencia17);
    asistenciaRepository.save(asistencia18);
    asistenciaRepository.save(asistencia19);
    asistenciaRepository.save(asistencia20);

    /*---------------------------------------------------------------------------------------------------------------------*/

  }
}
