package Grupo3.gestion_tareas.controller;

import Grupo3.gestion_tareas.model.Asignacion;
import Grupo3.gestion_tareas.repository.AsignacionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaciones")
@CrossOrigin
public class AsignacionController {

    private final AsignacionRepository asignacionRepository;

    public AsignacionController(AsignacionRepository asignacionRepository) {
        this.asignacionRepository = asignacionRepository;
    }

    // LISTAR
    @GetMapping
    public List<Asignacion> listar() {
        return asignacionRepository.findAll();
    }

    // OBTENER POR ID
    @GetMapping("/{id}")
    public Asignacion obtener(@PathVariable Long id) {
        return asignacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignación no encontrada"));
    }

    // CREAR
    @PostMapping
    public Asignacion crear(@RequestBody Asignacion asignacion) {
        return asignacionRepository.save(asignacion);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public Asignacion actualizar(@PathVariable Long id, @RequestBody Asignacion data) {

        Asignacion a = asignacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignación no encontrada"));

        a.setUsuarioId(data.getUsuarioId());
        a.setTareaId(data.getTareaId());
        a.setFechaAsignacion(data.getFechaAsignacion());

        return asignacionRepository.save(a);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        asignacionRepository.deleteById(id);
    }
}