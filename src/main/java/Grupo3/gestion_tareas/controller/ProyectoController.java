package Grupo3.gestion_tareas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Grupo3.gestion_tareas.model.Proyecto;
import Grupo3.gestion_tareas.repository.ProyectoRepository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/proyectos")
@CrossOrigin
public class ProyectoController {

    private final ProyectoRepository proyectoRepository;

    public ProyectoController(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    // GET → listar
    @GetMapping
    public List<Proyecto> listar(){
        return proyectoRepository.findAll();
    }

    // POST → crear
    @PostMapping
    public Proyecto crear(@RequestBody Proyecto proyecto){
        return proyectoRepository.save(proyecto);
    }

    // PUT → actualizar
    @PutMapping("/{id}")
    public Proyecto actualizar (@PathVariable Long id, @RequestBody Proyecto nuevoProyecto) {
        Proyecto proyecto = proyectoRepository.findById(id).orElse(null);
        
        if (proyecto == null) {
            throw new RuntimeException("Proyecto no encontrado con id: " + id);
        }

        proyecto.setNombre(nuevoProyecto.getNombre());
        proyecto.setDescripcion(nuevoProyecto.getDescripcion());
        proyecto.setFechaInicio(nuevoProyecto.getFechaInicio());
        proyecto.setFechaFin(nuevoProyecto.getFechaFin());

        return proyectoRepository.save(nuevoProyecto);
    }

    // DELETE → eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        proyectoRepository.deleteById(id);
    }
}
