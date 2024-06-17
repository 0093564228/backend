//package com.irojas.demojwt.User;
package uagrm.ficct.si2.registro_asistencia_docente.User;

import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Licencia.Licencia;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion.Programacion;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
/*@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")*/
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class User implements UserDetails {
  @Id
  @GeneratedValue
  Integer id;
  @Basic
  @Column(/*nullable = false*/)
  String username;
  @Column(/*nullable = false*/)
  String lastname;
  String firstname;
  String country;
  String password;
  String ci;
  String telefono;


  @Enumerated(EnumType.STRING)
  Role role;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL/*, orphanRemoval = true*/)
  /*@JsonManagedReference*/
  private List<Programacion> programaciones;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL/*, orphanRemoval = true*/)
  /*@JsonManagedReference*/
  private List<Licencia> licencias;

  public User(Integer id, String username, String lastname, String firstname, String country, String ci, String telefono, Object o) {
    this.id = id;
    this.username = username;
    this.lastname = lastname;
    this.firstname = firstname;
    this.country = country;
    this.ci = ci;
    this.telefono = telefono;

  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority((role.name())));
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
