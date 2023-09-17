package com.utn.Tp1JPA.Repositorios;

import com.utn.Tp1JPA.Entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
}

