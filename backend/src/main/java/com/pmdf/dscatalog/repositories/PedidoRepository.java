package com.pmdf.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmdf.dscatalog.entities.Pedido;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}



















