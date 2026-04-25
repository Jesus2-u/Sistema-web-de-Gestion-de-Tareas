package Grupo3.gestion_tareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Grupo3.gestion_tareas.model.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

}
