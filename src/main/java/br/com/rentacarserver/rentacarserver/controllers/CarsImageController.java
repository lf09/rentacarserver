package br.com.rentacarserver.rentacarserver.controllers;

import br.com.rentacarserver.rentacarserver.entities.CarsImageEntity;
import br.com.rentacarserver.rentacarserver.repositories.CarsImageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/carsimage")
public class CarsImageController {

    private CarsImageRepository carsImageRepository;

    public CarsImageController(CarsImageRepository carsImageRepository){
        this.carsImageRepository = carsImageRepository;
    }

    @GetMapping(path = "/allcarsimage")
    public List<CarsImageEntity> findAll(){
        return this.carsImageRepository.findAll();
    }

//    @GetMapping(path = "/allcarsimage/{name}")
//    public List<CarsImageEntity> findByName(@PathVariable(value = "name") String carsImageName){
//        return this.carsImageRepository.findByName(carsImageName);
//    }

    @PostMapping
    public void insertCarsImage(@RequestBody final CarsImageEntity carsImageEntity){
        try{
            this.carsImageRepository.save(carsImageEntity);
        }catch (Exception e){
            e.getMessage();
        }
    }

    @PutMapping
    public void updateCarsImage(@RequestBody final CarsImageEntity carsImageEntity){
        this.carsImageRepository.save(carsImageEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCarsImage(@PathVariable(value = "id") Long carsImageId){
        if(carsImageId != null) {
            this.carsImageRepository.deleteById(carsImageId);
        }
    }

}
