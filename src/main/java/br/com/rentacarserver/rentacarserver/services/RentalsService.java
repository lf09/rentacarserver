package br.com.rentacarserver.rentacarserver.services;

import br.com.rentacarserver.rentacarserver.entities.RentalsEntity;
import br.com.rentacarserver.rentacarserver.repositories.RentalsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class RentalsService {

    private RentalsRepository rentalsRepository;

    public RentalsService(RentalsRepository rentalsRepository){
        this.rentalsRepository = rentalsRepository;
    }

    public List<RentalsEntity> findAll(){
        return this.rentalsRepository.findAll();
    }

    public Optional<RentalsEntity> findById(@PathVariable(value = "id") Long rentalsId){
        return this.rentalsRepository.findById(rentalsId);
    }

    public void insertRentals(@RequestBody final RentalsEntity rentalsEntity){
        try{
            this.rentalsRepository.save(rentalsEntity);
        }catch (Exception e){
            e.getMessage();
        }
    }

    public void updateRentals(@RequestBody final RentalsEntity rentalsEntity){
        this.rentalsRepository.save(rentalsEntity);
    }

    public void deleteRentalsById(@PathVariable(value = "id") Long rentalsId){
        if(rentalsId != null) {
            this.rentalsRepository.deleteById(rentalsId);
        }
    }

}
