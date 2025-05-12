package com.reportes.reportes.api;

import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class VentaAPI {

    public String filtrarFecha(LocalDate inicio, LocalDate fin) {
        return "Total ventas entre fechas: $5,000";
    }

    public String compararPeriodo(LocalDate p1, LocalDate p2) {
        return "Periodo " + p1 + " generó $5,000 y " + p2 + " generó $6,500.";
    }
}
