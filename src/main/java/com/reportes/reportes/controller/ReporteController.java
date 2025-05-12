package com.reportes.reportes.controller;

import com.reportes.reportes.model.*;
import com.reportes.reportes.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public ResponseEntity<List<Reporte>> getReportes() {
        List<Reporte> reportes = reporteService.findAll();
        if (reportes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reportes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reporte> getReporteById(@PathVariable int id) {
        Reporte buscado = reporteService.findById(id);
        if (buscado != null) {
            return new ResponseEntity<>(buscado, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // POST: Reporte Inventario
    @PostMapping("/inventario")
    public ResponseEntity<ReporteInventario> crearReporteInventario() {
        ReporteInventario reporte = new ReporteInventario();
        reporte.setFechaCreacion(LocalDate.now());
        return new ResponseEntity<>(
                (ReporteInventario) reporteService.save(reporte),
                HttpStatus.CREATED
        );
    }

    // POST: Reporte Venta
    @PostMapping("/venta")
    public ResponseEntity<ReporteVenta> crearReporteVenta(@RequestBody ReporteVenta datos) {
        datos.setFechaCreacion(LocalDate.now());
        return new ResponseEntity<>(
                (ReporteVenta) reporteService.save(datos),
                HttpStatus.CREATED
        );
    }

    // POST: Reporte Rendimiento
    @PostMapping("/rendimiento")
    public ResponseEntity<ReporteRendimiento> crearReporteRendimiento(@RequestBody ReporteRendimiento datos) {
        datos.setFechaCreacion(LocalDate.now());
        return new ResponseEntity<>(
                (ReporteRendimiento) reporteService.save(datos),
                HttpStatus.CREATED
        );
    }
}
