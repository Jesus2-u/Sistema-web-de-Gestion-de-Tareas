package Grupo3.gestion_tareas.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "asignaciones")
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(name = "tarea_id", nullable = false)
    private Long tareaId;

    @Column(name = "fecha_asignacion")
    private LocalDateTime fechaAsignacion = LocalDateTime.now();

    public Asignacion() {}

    public Long getId() { return id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public Long getTareaId() { return tareaId; }
    public void setTareaId(Long tareaId) { this.tareaId = tareaId; }

    public LocalDateTime getFechaAsignacion() { return fechaAsignacion; }
    public void setFechaAsignacion(LocalDateTime fechaAsignacion) { this.fechaAsignacion = fechaAsignacion; }
}