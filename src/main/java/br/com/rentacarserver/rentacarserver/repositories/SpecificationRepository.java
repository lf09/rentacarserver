package br.com.rentacarserver.rentacarserver.repositories;

import br.com.rentacarserver.rentacarserver.entities.SpecificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecificationRepository extends JpaRepository<SpecificationEntity, Long> {

    List<SpecificationEntity> findByName( String name );
}
