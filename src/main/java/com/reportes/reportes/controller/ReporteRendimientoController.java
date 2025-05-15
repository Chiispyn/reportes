// ReporteRendimientoController.java
package com.reportes.reportes.controller;

import com.reportes.reportes.model.ReporteRendimiento;
import com.reportes.reportes.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reportes/rendimiento")
public class ReporteRendimientoController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public ResponseEntity<List<ReporteRendimiento>> obtenerTodosLosReportesRendimiento() {
        return new ResponseEntity<>(reporteService.obtenerTodosLosReportesRendimiento(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReporteRendimiento> obtenerReporteRendimientoPorId(@PathVariable int id) {
        Optional<ReporteRendimiento> reporte = reporteService.obtenerReporteRendimientoPorId(id);
        return reporte.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ReporteRendimiento> crearReporteRendimiento(@RequestBody ReporteRendimiento reporte) {
        ReporteRendimiento nuevoReporte = reporteService.guardarReporteRendimiento(reporte);
        return new ResponseEntity<>(nuevoReporte, HttpStatus.CREATED);
    }
}
