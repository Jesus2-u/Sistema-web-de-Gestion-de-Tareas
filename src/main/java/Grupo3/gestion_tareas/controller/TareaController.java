package Grupo3.gestion_tareas.controller;

import Grupo3.gestion_tareas.model.Tarea;
import Grupo3.gestion_tareas.repository.TareaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
@CrossOrigin
public class TareaController {

    private final TareaRepository tareaRepository;

    public TareaController(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    // LISTAR
    @GetMapping
    public List<Tarea> listar() {
        return tareaRepository.findAll();
    }

    // OBTENER POR ID
    @GetMapping("/{id}")
    public Tarea obtener(@PathVariable Long id) {
        return tareaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
    }

    // CREAR
    @PostMapping
    public Tarea crear(@RequestBody Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public Tarea actualizar(@PathVariable Long id, @RequestBody Tarea data) {

        Tarea t = tareaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));

        t.setTitulo(data.getTitulo());
        t.setDescripcion(data.getDescripcion());
        t.setEstado(data.getEstado());
        t.setPrioridad(data.getPrioridad());
        t.setFechaInicio(data.getFechaInicio());
        t.setFechaLimite(data.getFechaLimite());
        t.setProyectoId(data.getProyectoId());

        return tareaRepository.save(t);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        tareaRepository.deleteById(id);
    }
}