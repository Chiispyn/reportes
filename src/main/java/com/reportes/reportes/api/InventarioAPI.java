package com.reportes.reportes.api;

import org.springframework.stereotype.Component;

@Component
public class InventarioAPI {

    public String alertaBajoStock() {
        return "5 productos bajo el mínimo de stock.";
    }
}
