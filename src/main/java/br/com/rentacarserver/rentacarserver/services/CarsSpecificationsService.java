package br.com.rentacarserver.rentacarserver.services;

import br.com.rentacarserver.rentacarserver.entities.CarsSpecificationsEntity;
import br.com.rentacarserver.rentacarserver.repositories.CarsSpecificationsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;

@Service
public class CarsSpecificationsService {

    private CarsSpecificationsRepository carsSpecificationsRepository;

    public CarsSpecificationsService(CarsSpecificationsRepository carsSpecificationsRepository){
        this.carsSpecificationsRepository = carsSpecificationsRepository;
    }

    public List<CarsSpecificationsEntity> findAll(){
        return this.carsSpecificationsRepository.findAll();
    }

    public Optional<CarsSpecificationsEntity> findByName(@PathVariable(value = "id") Long carsSpecificationsId){
        return this.carsSpecificationsRepository.findById(carsSpecificationsId);
    }

    public void insertCarsSpecifications(@RequestBody final CarsSpecificationsEntity carsSpecificationsEntity){
        try{
            this.carsSpecificationsRepository.save(carsSpecificationsEntity);
        }catch (Exception e){
            e.getMessage();
        }
    }

    public void updateCarsSpecifications(@RequestBody final CarsSpecificationsEntity carsSpecificationsEntity){
        this.carsSpecificationsRepository.save(carsSpecificationsEntity);
    }

    public void deleteCarsSpecificationsById(@PathVariable(value = "id") Long carsSpecifcationsId){
        if(carsSpecifcationsId != null) {
            this.carsSpecificationsRepository.deleteById(carsSpecifcationsId);
        }
    }

}
