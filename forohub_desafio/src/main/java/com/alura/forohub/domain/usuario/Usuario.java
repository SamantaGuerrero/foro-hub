package com.alura.forohub.domain.usuario;
import jakarta.persistence.*; import org.springframework.security.core.*; import org.springframework.security.core.authority.SimpleGrantedAuthority; import org.springframework.security.core.userdetails.UserDetails; import java.util.*;
@Entity @Table(name="usuarios")
public class Usuario implements UserDetails {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String nombre; @Column(unique=true, nullable=false) private String email; private String password;
 @Enumerated(EnumType.STRING) private Role role=Role.USER;
 public Usuario() {}
 public Long getId(){return id;} public String getNombre(){return nombre;} public void setNombre(String n){this.nombre=n;}
 public String getEmail(){return email;} public void setEmail(String e){this.email=e;} public String getPassword(){return password;} public void setPassword(String p){this.password=p;}
 public Role getRole(){return role;} public void setRole(Role r){this.role=r;}
 @Override public Collection<? extends GrantedAuthority> getAuthorities(){ return List.of(new SimpleGrantedAuthority("ROLE_"+(role==null?"USER":role.name()))); }
 @Override public String getUsername(){return email;} @Override public boolean isAccountNonExpired(){return true;}
 @Override public boolean isAccountNonLocked(){return true;} @Override public boolean isCredentialsNonExpired(){return true;} @Override public boolean isEnabled(){return true;}
}
