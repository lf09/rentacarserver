package br.com.rentacarserver.rentacarserver.repositories;

import br.com.rentacarserver.rentacarserver.entities.CarsSpecificationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarsSpecificationRepository extends JpaRepository<CarsSpecificationsEntity, Long>{

//    List<CarsSpecificationsEntity> findByName(String name );
}
