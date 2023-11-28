package org.restaurante.repository;

import org.restaurante.model.Postres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostresRepository extends JpaRepository<Postres, String>{

}
