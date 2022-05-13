package br.com.rentacarserver.rentacarserver.repositories;

import br.com.rentacarserver.rentacarserver.entities.CarsSpecificationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CarsSpecificationsRepository extends JpaRepository<CarsSpecificationsEntity, Long>{

    Optional<CarsSpecificationsEntity> findById( Long id );
}
