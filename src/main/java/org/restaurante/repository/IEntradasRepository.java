package org.restaurante.repository;

import org.restaurante.model.Entradas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEntradasRepository extends JpaRepository<Entradas, String>{

}
