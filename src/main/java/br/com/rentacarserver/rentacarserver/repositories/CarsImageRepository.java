package br.com.rentacarserver.rentacarserver.repositories;

import br.com.rentacarserver.rentacarserver.entities.CarsImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarsImageRepository extends JpaRepository<CarsImageEntity, Long> {

//    List<CarsImageEntity> findByName( String name );
}
