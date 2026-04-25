package Grupo3.gestion_tareas.model;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "Asignacion")
public class Asignacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;
    @Column(name = "tarea_id", nullable = false)
    private Long tareaId;
    @Column(name = "fechaAsignacion")
    private LocalDate fechaAsignacion;
    public Asignacion() {}
    public Asignacion(Long usuarioId, Long tareaId) {
        this.usuarioId = usuarioId;
        this.tareaId = tareaId;
        this.fechaAsignacion = LocalDate.now();
    }

    public Long getId() {
        return id;
    }
    public Long getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
    public Long getTareaId() {
        return tareaId;
    }
    public void setTareaId(Long tareaId) {
        this.tareaId = tareaId;
    }
    public LocalDate getFechaAsignacion() {
        return fechaAsignacion;
    }
    public void setFechaAsignacion(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }
}
