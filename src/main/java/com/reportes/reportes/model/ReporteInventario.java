package com.reportes.reportes.model;

import com.reportes.reportes.api.InventarioAPI;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reporte_inventario")
public class ReporteInventario extends Reporte {

    @Transient
    private InventarioAPI inventarioAPI;

    @Override
    public String generarReporte() {
        return "Reporte Inventario:\n" + inventarioAPI.alertaBajoStock();
    }
}
