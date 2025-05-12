package com.reportes.reportes.model;

import com.reportes.reportes.api.InventarioAPI;
import com.reportes.reportes.api.VentaAPI;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reporte_rendimiento")
public class ReporteRendimiento extends Reporte {

    @Transient
    private InventarioAPI inventarioAPI;

    @Transient
    private VentaAPI ventaAPI;

    private LocalDate periodo1;
    private LocalDate periodo2;

    @Override
    public String generarReporte() {
        return "Rendimiento comparado entre " + periodo1 + " y " + periodo2 + ":\n" +
                ventaAPI.compararPeriodo(periodo1, periodo2);
    }
}
