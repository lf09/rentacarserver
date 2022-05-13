package br.com.rentacarserver.rentacarserver.services;

import br.com.rentacarserver.rentacarserver.entities.CarsEntity;
import br.com.rentacarserver.rentacarserver.repositories.CarsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CarsService {

    private CarsRepository carsRepository;

    public CarsService(CarsRepository brandRepository){
        this.carsRepository = brandRepository;
    }

    public List<CarsEntity> findAll(){
        return this.carsRepository.findAll();
    }

    public List<CarsEntity> findByName(@PathVariable(value = "name") String carsName){
        return this.carsRepository.findByName(carsName);
    }

    public void insertBrand(@RequestBody final CarsEntity carsEntity){
        try{
            this.carsRepository.save(carsEntity);
        }catch (Exception e){
            e.getMessage();
        }
    }

    public void updateCars(@RequestBody final CarsEntity carsEntity){
        this.carsRepository.save(carsEntity);
    }

    public void deleteCarsById(@PathVariable(value = "id") Long carsId){
        if(carsId != null) {
            this.carsRepository.deleteById(carsId);
        }
    }

}
