package br.com.rentacarserver.rentacarserver.controllers;

import br.com.rentacarserver.rentacarserver.entities.CustomersEntity;
import br.com.rentacarserver.rentacarserver.repositories.CustomersRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/customers")
public class CustomersController {

    private CustomersRepository customersRepository;

    public CustomersController(CustomersRepository customersRepository){
        this.customersRepository = customersRepository;
    }

    @GetMapping(path = "/allcustomers")
    public List<CustomersEntity> findAll(){
        return this.customersRepository.findAll();
    }

    @GetMapping(path = "/allbrands/{name}")
    public List<CustomersEntity> findByName(@PathVariable(value = "name") String customersName){
        return this.customersRepository.findByName(customersName);
    }

    @PostMapping
    public void insert(@RequestBody final CustomersEntity customersEntity){
        try{
            this.customersRepository.save(customersEntity);
        }catch (Exception e){
            e.getMessage();
        }
    }

    @PutMapping
    public void update(@RequestBody final CustomersEntity customersEntity){
        this.customersRepository.save(customersEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable(value = "id") Long customersId){
        if(customersId != null) {
            this.customersRepository.deleteById(customersId);
        }
    }

}
