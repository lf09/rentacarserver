package br.com.rentacarserver.rentacarserver.repositories;

import br.com.rentacarserver.rentacarserver.entities.RentalsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalsRepository extends JpaRepository<RentalsEntity, Long>{

//    List<RentalsEntity> findByName( String name );
}
