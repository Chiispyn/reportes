// ReporteVentaController.java
package com.reportes.reportes.controller;

import com.reportes.reportes.model.ReporteVenta;
import com.reportes.reportes.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reportes/venta")
public class ReporteVentaController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public ResponseEntity<List<ReporteVenta>> obtenerTodosLosReportesVenta() {
        return new ResponseEntity<>(reporteService.obtenerTodosLosReportesVenta(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReporteVenta> obtenerReporteVentaPorId(@PathVariable int id) {
        Optional<ReporteVenta> reporte = reporteService.obtenerReporteVentaPorId(id);
        return reporte.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ReporteVenta> crearReporteVenta(@RequestBody ReporteVenta reporte) {
        ReporteVenta nuevoReporte = reporteService.guardarReporteVenta(reporte);
        return new ResponseEntity<>(nuevoReporte, HttpStatus.CREATED);
    }
}
