package org.restaurante.repository;

import org.restaurante.model.Lacteos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILacteosRepository extends JpaRepository<Lacteos, String> {

}
