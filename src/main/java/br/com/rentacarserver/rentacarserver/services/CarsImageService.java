package br.com.rentacarserver.rentacarserver.services;

import br.com.rentacarserver.rentacarserver.entities.CarsImageEntity;
import br.com.rentacarserver.rentacarserver.repositories.CarsImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CarsImageService {

    CarsImageRepository carsImageRepository;

    public CarsImageService(CarsImageRepository carsImageRepository){
        this.carsImageRepository = carsImageRepository;
    }

    public List<CarsImageEntity> findAll(){
        return this.carsImageRepository.findAll();
    }

    public Optional<CarsImageEntity> findById(@PathVariable(value = "name") Long carsImageId){
        return this.carsImageRepository.findById(carsImageId);
    }

    public void insert(@RequestBody final CarsImageEntity brandEntity){
        try{
            this.carsImageRepository.save(brandEntity);
        }catch (Exception e){
            e.getMessage();
        }
    }

    public void updateBrand(@RequestBody final CarsImageEntity brandEntity){
        this.carsImageRepository.save(brandEntity);
    }

    public void deleteById(@PathVariable(value = "id") Long brandId){
        if(brandId != null) {
            this.carsImageRepository.deleteById(brandId);
        }
    }

}
