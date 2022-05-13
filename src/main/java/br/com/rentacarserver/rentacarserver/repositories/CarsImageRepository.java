package br.com.rentacarserver.rentacarserver.repositories;

import br.com.rentacarserver.rentacarserver.entities.CarsImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CarsImageRepository extends JpaRepository<CarsImageEntity, Long> {

    Optional<CarsImageEntity> findById(Long id );
}
