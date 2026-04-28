package Grupo3.gestion_tareas.controller;
import Grupo3.gestion_tareas.model.Asignacion;
import Grupo3.gestion_tareas.repository.AsignacionRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/asignaciones")
@CrossOrigin
public class AsignacionController {
    private final AsignacionRepository asignacionRepository;
    public AsignacionController(AsignacionRepository asignacionRepository) {
        this.asignacionRepository = asignacionRepository;
    }
    // GET listar
    @GetMapping
    public List<Asignacion> listar() {
        return asignacionRepository.findAll();
    }
    // POST crear
    @PostMapping
    public Asignacion crear(@RequestBody Asignacion asignacion) {
        return asignacionRepository.save(asignacion);
    }
    // PUT actualizar
    @PutMapping("/{id}")
    public Asignacion actualizar(@PathVariable Long id, @RequestBody Asignacion nuevaAsignacion) {
        Asignacion asignacion = asignacionRepository.findById(id).orElse(null);
        if (asignacion == null) {
            throw new RuntimeException("Asignación no encontrada");
        }
        asignacion.setUsuarioId(nuevaAsignacion.getUsuarioId());
        asignacion.setTareaId(nuevaAsignacion.getTareaId());
        asignacion.setFechaAsignacion(nuevaAsignacion.getFechaAsignacion());
        return asignacionRepository.save(asignacion);
    }
    // DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        asignacionRepository.deleteById(id);
    }
}