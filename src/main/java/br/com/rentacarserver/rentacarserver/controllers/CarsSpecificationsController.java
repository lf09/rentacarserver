package br.com.rentacarserver.rentacarserver.controllers;

import br.com.rentacarserver.rentacarserver.entities.CarsSpecificationsEntity;
import br.com.rentacarserver.rentacarserver.repositories.CarsSpecificationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/carsspecifications")
public class CarsSpecificationsController {

    private CarsSpecificationRepository carsSpecificationRepository;

    public CarsSpecificationsController(CarsSpecificationRepository carsSpecificationRepository){
        this.carsSpecificationRepository = carsSpecificationRepository;
    }

    @GetMapping(path = "/allcarsspecifications")
    public List<CarsSpecificationsEntity> findAll(){
        return this.carsSpecificationRepository.findAll();
    }

//    @GetMapping(path = "/allcarsspecifications/{name}")
//    public List<CarsSpecificationsEntity> findByName(@PathVariable(value = "name") String carsSpecificationsName){
//        return this.carsSpecificationRepository.findByName(carsSpecificationsName);
//    }

    @PostMapping
    public void insertCarsSpecifications(@RequestBody final CarsSpecificationsEntity carsSpecificationsEntity){
        try{
            this.carsSpecificationRepository.save(carsSpecificationsEntity);
        }catch (Exception e){
            e.getMessage();
        }
    }

    @PutMapping
    public void updateCarsSpecifications(@RequestBody final CarsSpecificationsEntity carsSpecificationsEntity){
        this.carsSpecificationRepository.save(carsSpecificationsEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCarsSpecifications(@PathVariable(value = "id") Long carsSpecificationsId){
        if(carsSpecificationsId != null){
            this.carsSpecificationRepository.deleteById(carsSpecificationsId);
        }
    }

}
