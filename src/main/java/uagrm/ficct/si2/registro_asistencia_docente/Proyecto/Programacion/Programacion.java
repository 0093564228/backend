package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.Facultad;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo.Grupo;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.Materia;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Modulo_Aula.Aula;
import uagrm.ficct.si2.registro_asistencia_docente.User.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
/*@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")*/
public class Programacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private LocalDate horario_inicio;

    @Column
    private LocalDate horario_fin;

    /*1*/
   /* @Column
    private Integer grupos_id;

    @Column
    private Integer materias_id;*/

    /*2*/
    @ManyToOne
    @JoinColumn(name = "materia_id"/*, nullable = false*/)
    /*@JsonBackReference*/
    private Materia materia;


    @ManyToOne
    @JoinColumn(name = "grupo_id"/*, nullable = false*/)
    /*@JsonBackReference*/
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name = "aula_id"/*, nullable = false*/)
    /*@JsonBackReference*/
    private Aula aula;

    @ManyToOne
    @JoinColumn(name = "user_id"/*, nullable = false*/)
    /*@JsonBackReference*/
    private User user;

/*
    @ManyToMany
    @JoinTable(
            name = "programacion",
            joinColumns = @JoinColumn(name = "programacion_id"),
            inverseJoinColumns = @JoinColumn(name = "grupo_id")
    )
    private Set<Grupo> grupos;

    @ManyToMany
    @JoinTable(
            name = "programacion",
            joinColumns = @JoinColumn(name = "programacion_id"),
            inverseJoinColumns = @JoinColumn(name = "materia_id")
    )
    private Set<Materia> materias;*/
}