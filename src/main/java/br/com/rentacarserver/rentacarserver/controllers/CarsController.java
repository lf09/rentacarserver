package br.com.rentacarserver.rentacarserver.controllers;

import br.com.rentacarserver.rentacarserver.entities.CarsEntity;
import br.com.rentacarserver.rentacarserver.repositories.CarsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity insertCars(@RequestBody final CarsEntity carsEntity){
        try{
            this.carsRepository.save(carsEntity);
            return new ResponseEntity(HttpStatus.CREATED);
        }catch (Exception e){
            e.getMessage();
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping
    public ResponseEntity updateCars(@RequestBody final CarsEntity carsEntity){
        try{
            this.carsRepository.save(carsEntity);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            e.getMessage();
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCars(@PathVariable(value = "id") Long carsId){
        try{
            this.carsRepository.deleteById(carsId);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            e.getMessage();
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
