// ReporteInventarioController.java
package com.reportes.reportes.controller;

import com.reportes.reportes.model.ReporteInventario;
import com.reportes.reportes.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reportes/inventario")
public class ReporteInventarioController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public ResponseEntity<List<ReporteInventario>> obtenerTodosLosReportesInventario() {
        return new ResponseEntity<>(reporteService.obtenerTodosLosReportesInventario(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReporteInventario> obtenerReporteInventarioPorId(@PathVariable int id) {
        Optional<ReporteInventario> reporte = reporteService.obtenerReporteInventarioPorId(id);
        return reporte.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ReporteInventario> crearReporteInventario(@RequestBody ReporteInventario reporteInventario) {
        ReporteInventario nuevoReporte = reporteService.guardarReporteInventario(reporteInventario);
        return new ResponseEntity<>(nuevoReporte, HttpStatus.CREATED);
    }
}
