package com.pmdf.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmdf.dscatalog.entities.ItemPedido;
import com.pmdf.dscatalog.entities.ItemPedidoPK;


@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK>{

	

}




















