//package com.irojas.demojwt.Auth;
package uagrm.ficct.si2.registro_asistencia_docente.Auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//import com.irojas.demojwt.Jwt.JwtService;
//import com.irojas.demojwt.User.Role;
//import com.irojas.demojwt.User.User;
//import com.irojas.demojwt.User.UserRepository;

import uagrm.ficct.si2.registro_asistencia_docente.Jwt.JwtService;
import uagrm.ficct.si2.registro_asistencia_docente.User.Role;
import uagrm.ficct.si2.registro_asistencia_docente.User.User;
import uagrm.ficct.si2.registro_asistencia_docente.User.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final UserRepository userRepository;
  private final JwtService jwtService;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;

  public AuthResponse login(LoginRequest request) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
    UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
    String token = jwtService.getToken(user);
    String username = userRepository.findByUsername(request.getUsername()).get().getUsername();
    return AuthResponse.builder()
            .username(username)
            .token(token)
            .build();

  }

  public AuthResponse register(RegisterRequest request) {
    User user = User.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()))
            .firstname(request.getFirstname())
            .lastname(request.lastname)
            .country(request.getCountry())
            .ci(request.ci)
            .telefono(request.telefono)
            .role(Role.USER)
            .build();

    userRepository.save(user);

    return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();

  }

}
