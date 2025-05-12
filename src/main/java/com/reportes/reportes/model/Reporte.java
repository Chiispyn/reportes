package com.reportes.reportes.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reporte")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate fechaCreacion;

    public abstract String generarReporte();

    public String mostrarReporte() {
        return "Reporte ID " + id + " generado el " + fechaCreacion;
    }
}
