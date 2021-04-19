package com.pmdf.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmdf.dscatalog.entities.Categoria;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}




















