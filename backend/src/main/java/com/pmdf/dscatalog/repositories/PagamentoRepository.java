package com.pmdf.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmdf.dscatalog.entities.Pagamento;


@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{

}




















