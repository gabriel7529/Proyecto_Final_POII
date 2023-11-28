package org.restaurante.repository;


import org.restaurante.model.Sopas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISopasRepository extends JpaRepository<Sopas, String>{

}
