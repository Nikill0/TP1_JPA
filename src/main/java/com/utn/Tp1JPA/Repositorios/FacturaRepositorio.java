package com.utn.Tp1JPA.Repositorios;

import com.utn.Tp1JPA.Entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepositorio extends JpaRepository<Factura, Long> {
}
