package com.pegue.pague.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pegue.pague.api.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


}
