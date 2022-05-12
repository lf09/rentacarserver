package br.com.rentacarserver.rentacarserver.controllers;

import br.com.rentacarserver.rentacarserver.entities.SpecificationEntity;
import br.com.rentacarserver.rentacarserver.repositories.SpecificationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/specification")
public class SpecificationController {

    private SpecificationRepository specificationRepository;

    public SpecificationController(SpecificationRepository specificationRepository){
        this.specificationRepository = specificationRepository;
    }

    @GetMapping(path = "/allspecification")
    public List<SpecificationEntity> findAll(){
        return this.specificationRepository.findAll();
    }

    @GetMapping(path = "/allspecification/{name}")
    public List<SpecificationEntity> findByName(@PathVariable(value = "name") String specificationName ){
        return this.specificationRepository.findByName(specificationName);
    }

    @PostMapping
    public void insert(@RequestBody final SpecificationEntity specificationEntity){
        try{
            this.specificationRepository.save(specificationEntity);
        }catch (Exception e){
            e.getMessage();
        }
    }

    @PutMapping
    public void update(@RequestBody final SpecificationEntity specificationEntity){
        this.specificationRepository.save(specificationEntity);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteById(@PathVariable(value = "id") Long specificationId){
        if(specificationId != null) {
            this.specificationRepository.deleteById(specificationId);
        }
    }
}
