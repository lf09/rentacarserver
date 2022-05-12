package br.com.rentacarserver.rentacarserver.repositories;

import br.com.rentacarserver.rentacarserver.entities.CarsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarsRepository extends JpaRepository<CarsEntity, Long> {

    List<CarsEntity> findByName( String name );
}