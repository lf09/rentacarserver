package br.com.rentacarserver.rentacarserver.controllers;

import br.com.rentacarserver.rentacarserver.entities.CarsSpecificationsEntity;
import br.com.rentacarserver.rentacarserver.repositories.CarsSpecificationsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/carsspecifications")
public class CarsSpecificationsController {

    private CarsSpecificationsRepository carsSpecificationsRepository;

    public CarsSpecificationsController(CarsSpecificationsRepository carsSpecificationsRepository){
        this.carsSpecificationsRepository = carsSpecificationsRepository;
    }

    @GetMapping(path = "/allcarsspecifications")
    public List<CarsSpecificationsEntity> findAll(){
        return this.carsSpecificationsRepository.findAll();
    }

//    @GetMapping(path = "/allcarsspecifications/{name}")
//    public List<CarsSpecificationsEntity> findByName(@PathVariable(value = "name") String carsSpecificationsName){
//        return this.carsSpecificationRepository.findByName(carsSpecificationsName);
//    }

    @PostMapping
    public void insertCarsSpecifications(@RequestBody final CarsSpecificationsEntity carsSpecificationsEntity){
        try{
            this.carsSpecificationsRepository.save(carsSpecificationsEntity);
        }catch (Exception e){
            e.getMessage();
        }
    }

    @PutMapping
    public void updateCarsSpecifications(@RequestBody final CarsSpecificationsEntity carsSpecificationsEntity){
        this.carsSpecificationsRepository.save(carsSpecificationsEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCarsSpecifications(@PathVariable(value = "id") Long carsSpecificationsId){
        if(carsSpecificationsId != null){
            this.carsSpecificationsRepository.deleteById(carsSpecificationsId);
        }
    }

}
