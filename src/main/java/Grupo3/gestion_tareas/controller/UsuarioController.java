package Grupo3.gestion_tareas.controller;

import Grupo3.gestion_tareas.model.Usuario;
import Grupo3.gestion_tareas.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // LISTAR TODOS
    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Usuario obtener(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // CREAR
    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Long id, @RequestBody Usuario data) {

        Usuario u = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        u.setNombre(data.getNombre());
        u.setCorreo(data.getCorreo());
        u.setPassword(data.getPassword());
        u.setRol(data.getRol());
        u.setActivo(data.isActivo());

        return usuarioRepository.save(u);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }
}