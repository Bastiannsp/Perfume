package com.perfum.perfumeria.dto;

import java.sql.Date;

public interface VentasPorFecha {
    Date getFecha();   // día (yyyy-MM-dd)
    Double getVentas();
}
