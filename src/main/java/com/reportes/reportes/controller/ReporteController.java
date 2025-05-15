// ReporteController.java
package com.reportes.reportes.controller;

import com.reportes.reportes.model.Reporte;
import com.reportes.reportes.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public ResponseEntity<List<Reporte>> obtenerTodosLosReportes() {
        return new ResponseEntity<>(reporteService.obtenerTodosLosReportes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reporte> obtenerReportePorId(@PathVariable int id) {
        Optional<Reporte> reporte = reporteService.obtenerReportePorId(id);
        return reporte.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Reporte> crearReporte(@RequestBody Reporte reporte) {
        Reporte nuevoReporte = reporteService.guardarReporte(reporte);
        return new ResponseEntity<>(nuevoReporte, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReporte(@PathVariable int id) {
        reporteService.eliminarReporte(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
