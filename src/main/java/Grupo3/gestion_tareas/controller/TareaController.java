package Grupo3.gestion_tareas.controller;

import Grupo3.gestion_tareas.model.Tarea;
import Grupo3.gestion_tareas.repository.TareaRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
@CrossOrigin
public class TareaController {

    private final TareaRepository tareaRepository;

    public TareaController(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    // GET → listar
    @GetMapping
    public List<Tarea> listar() {
        return tareaRepository.findAll();
    }

    // POST → crear
    @PostMapping
    public Tarea crear(@RequestBody Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    // PUT → actualizar
    @PutMapping("/{id}")
public Tarea actualizar(@PathVariable Long id, @RequestBody Tarea nuevaTarea) {

    Tarea tarea = tareaRepository.findById(id).orElse(null);

    if (tarea == null) {
        throw new RuntimeException("Tarea no encontrada");
    }

    tarea.setTitulo(nuevaTarea.getTitulo());
    tarea.setDescripcion(nuevaTarea.getDescripcion());
    tarea.setEstado(nuevaTarea.getEstado());
    tarea.setPrioridad(nuevaTarea.getPrioridad());
    tarea.setFechaInicio(nuevaTarea.getFechaInicio());
    tarea.setFechaLimite(nuevaTarea.getFechaLimite());

    return tareaRepository.save(tarea);
}
    // DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        tareaRepository.deleteById(id);
    }
}