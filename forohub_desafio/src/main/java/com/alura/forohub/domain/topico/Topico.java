package com.alura.forohub.domain.topico;
import com.alura.forohub.domain.curso.Curso; import com.alura.forohub.domain.usuario.Usuario;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="topicos")
public class Topico {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String titulo; @Column(nullable=false, length=4000) private String mensaje;
 private LocalDateTime fechaCreacion=LocalDateTime.now(); @Enumerated(EnumType.STRING) private StatusTopico status=StatusTopico.ABIERTO;
 @ManyToOne(optional=false) private Usuario autor; @ManyToOne(optional=false) private Curso curso;
 public Topico() {} public Topico(String t,String m,Usuario a,Curso c){this.titulo=t;this.mensaje=m;this.autor=a;this.curso=c;}
 public Long getId(){return id;} public String getTitulo(){return titulo;} public void setTitulo(String t){this.titulo=t;}
 public String getMensaje(){return mensaje;} public void setMensaje(String m){this.mensaje=m;} public LocalDateTime getFechaCreacion(){return fechaCreacion;}
 public StatusTopico getStatus(){return status;} public void setStatus(StatusTopico s){this.status=s;} public Usuario getAutor(){return autor;} public void setAutor(Usuario a){this.autor=a;}
 public Curso getCurso(){return curso;} public void setCurso(Curso c){this.curso=c;}
}
