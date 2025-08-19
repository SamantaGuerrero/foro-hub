package com.alura.forohub.service;
import com.alura.forohub.domain.curso.Curso; import com.alura.forohub.domain.topico.Topico; import com.alura.forohub.dto.topico.*; import com.alura.forohub.repository.*; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional; import java.util.List;
@Service public class TopicoService {
 private final TopicoRepository topicoRepository; private final CursoRepository cursoRepository;
 public TopicoService(TopicoRepository t, CursoRepository c){this.topicoRepository=t; this.cursoRepository=c;}
 @Transactional(readOnly=true) public List<TopicoResponseDTO> listar(){ return topicoRepository.findAll().stream().map(t-> new TopicoResponseDTO(t.getId(),t.getTitulo(),t.getMensaje(),t.getFechaCreacion(),t.getStatus().name(),t.getAutor().getEmail(),t.getCurso().getNombre())).toList(); }
 @Transactional(readOnly=true) public TopicoResponseDTO obtener(Long id){ var t=topicoRepository.findById(id).orElseThrow(()->new RuntimeException("Tópico no encontrado")); return new TopicoResponseDTO(t.getId(),t.getTitulo(),t.getMensaje(),t.getFechaCreacion(),t.getStatus().name(),t.getAutor().getEmail(),t.getCurso().getNombre()); }
 @Transactional public Topico crear(CreateTopicoDTO dto, com.alura.forohub.domain.usuario.Usuario autor){ Curso curso = cursoRepository.findById(dto.getCursoId()).orElseThrow(()->new RuntimeException("Curso no encontrado")); Topico t = new Topico(dto.getTitulo(), dto.getMensaje(), autor, curso); return topicoRepository.save(t); }
 @Transactional public Topico actualizar(Long id, UpdateTopicoDTO dto){ Topico t = topicoRepository.findById(id).orElseThrow(()->new RuntimeException("Tópico no encontrado")); t.setTitulo(dto.getTitulo()); t.setMensaje(dto.getMensaje()); return t; }
 @Transactional public void eliminar(Long id){ if(!topicoRepository.existsById(id)) throw new RuntimeException("Tópico no encontrado"); topicoRepository.deleteById(id); }
}
