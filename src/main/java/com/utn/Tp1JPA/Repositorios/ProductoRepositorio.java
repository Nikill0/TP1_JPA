package com.utn.Tp1JPA.Repositorios;

import com.utn.Tp1JPA.Entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
}
