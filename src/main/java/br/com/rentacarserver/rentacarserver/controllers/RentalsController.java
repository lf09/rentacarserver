package br.com.rentacarserver.rentacarserver.controllers;

import br.com.rentacarserver.rentacarserver.entities.RentalsEntity;
import br.com.rentacarserver.rentacarserver.repositories.RentalsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/rentals")
public class RentalsController {

    private RentalsRepository rentalsRepository;

    public RentalsController(RentalsRepository rentalsRepository){
        this.rentalsRepository = rentalsRepository;
    }

    @GetMapping(path = "/allrentals")
    public List<RentalsEntity> findAll(){
        return this.rentalsRepository.findAll();
    }

//    @GetMapping(path = "/allrentals/{name}")
//    public List<RentalsEntity> findByName(@PathVariable(value = "name") String rentalsName){
//        return this.rentalsRepository.findByName(rentalsName);
//    }

    @PostMapping
    public void insert(@RequestBody final RentalsEntity rentalsEntity){
        try{
            this.rentalsRepository.save(rentalsEntity);
        }catch (Exception e){
            e.getMessage();
        }
    }

    @PutMapping
    public void update(@RequestBody final RentalsEntity rentalsEntity){
        this.rentalsRepository.save(rentalsEntity);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteById(@PathVariable(value = "id") Long rentalsId){
        if(rentalsId != null){
            this.rentalsRepository.deleteById(rentalsId);
        }
    }


}
