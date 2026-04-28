package Grupo3.gestion_tareas.controller;

import Grupo3.gestion_tareas.model.Proyecto;
import Grupo3.gestion_tareas.repository.ProyectoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
@CrossOrigin
public class ProyectoController {

    private final ProyectoRepository proyectoRepository;

    public ProyectoController(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    // LISTAR
    @GetMapping
    public List<Proyecto> listar() {
        return proyectoRepository.findAll();
    }

    // OBTENER POR ID
    @GetMapping("/{id}")
    public Proyecto obtener(@PathVariable Long id) {
        return proyectoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
    }

    // CREAR
    @PostMapping
    public Proyecto crear(@RequestBody Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public Proyecto actualizar(@PathVariable Long id, @RequestBody Proyecto data) {

        Proyecto p = proyectoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        p.setNombre(data.getNombre());
        p.setDescripcion(data.getDescripcion());
        p.setFechaInicio(data.getFechaInicio());
        p.setFechaFin(data.getFechaFin());
        p.setEstado(data.getEstado());

        return proyectoRepository.save(p);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        proyectoRepository.deleteById(id);
    }
}