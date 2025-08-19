package com.alura.forohub.domain.curso;
import jakarta.persistence.*;
@Entity @Table(name="cursos")
public class Curso {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false, unique=true) private String nombre;
 public Curso() {} public Curso(String nombre){this.nombre=nombre;}
 public Long getId(){return id;} public String getNombre(){return nombre;} public void setNombre(String n){this.nombre=n;}
}
