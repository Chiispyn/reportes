package com.reportes.reportes.service;

import com.reportes.reportes.model.Reporte;
import com.reportes.reportes.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    public List<Reporte> findAll() {
        return reporteRepository.findAll();
    }

    public Reporte findById(int id) {
        return reporteRepository.findById(id).orElse(null);
    }

    public Reporte save(Reporte reporte) {
        return reporteRepository.save(reporte);
    }
}
