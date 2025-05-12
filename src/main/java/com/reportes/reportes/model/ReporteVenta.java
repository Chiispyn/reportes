package com.reportes.reportes.model;

import com.reportes.reportes.api.VentaAPI;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reporte_venta")
public class ReporteVenta extends Reporte {

    @Transient
    private VentaAPI ventaAPI;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @Override
    public String generarReporte() {
        return "Reporte de Ventas del " + fechaInicio + " al " + fechaFin + ":\n" +
                ventaAPI.filtrarFecha(fechaInicio, fechaFin);
    }
}
