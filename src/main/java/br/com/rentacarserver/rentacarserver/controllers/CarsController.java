package br.com.rentacarserver.rentacarserver.controllers;

import br.com.rentacarserver.rentacarserver.entities.CarsEntity;
import br.com.rentacarserver.rentacarserver.repositories.CarsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/cars")
public class CarsController {

    private CarsRepository carsRepository;

    public CarsController( CarsRepository carsRepository ){
        this.carsRepository = carsRepository;
    }

    @GetMapping(path = "/allcars")
    public List<CarsEntity> findAll(){
        return this.carsRepository.findAll();
    }

    @GetMapping(path = "/allcars/{name}")
    public List<CarsEntity> findByName(@PathVariable(value = "name") String carsName){
        return this.carsRepository.findByName(carsName);
    }

    @PostMapping
    public void insertCars(@RequestBody final CarsEntity carsEntity){
        try{
            this.carsRepository.save(carsEntity);
        }catch (Exception e){
            e.getMessage();
        }
    }

    @PutMapping
    public void updateCars(@RequestBody final CarsEntity carsEntity){
        this.carsRepository.save(carsEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCars(@PathVariable(value = "id") Long carsId){
        if(carsId != null){
            this.carsRepository.deleteById(carsId);
        }
    }

}
