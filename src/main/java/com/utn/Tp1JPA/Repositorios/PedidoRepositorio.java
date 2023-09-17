package com.utn.Tp1JPA.Repositorios;

import com.utn.Tp1JPA.Entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {
}
