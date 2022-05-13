package br.com.rentacarserver.rentacarserver.controllers;

import br.com.rentacarserver.rentacarserver.entities.SpecificationEntity;
import br.com.rentacarserver.rentacarserver.services.SpecificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/specification")
public class SpecificationController {

    private SpecificationService specificationService;

    public SpecificationController(SpecificationService specificationService){
        this.specificationService = specificationService;
    }

    @GetMapping(path = "/allspecification")
    public List<SpecificationEntity> findAll(){
        return this.specificationService.findAll();
    }

    @GetMapping(path = "/allspecification/{name}")
    public List<SpecificationEntity> findByName(@PathVariable(value = "name") String specificationName ){
        return this.specificationService.findByName(specificationName);
    }

    @PostMapping
    public void insert(@RequestBody final SpecificationEntity specificationEntity){
        try{
            this.specificationService.insertSpecification(specificationEntity);
        }catch (Exception e){
            e.getMessage();
        }
    }

    @PutMapping
    public void update(@RequestBody final SpecificationEntity specificationEntity){
        this.specificationService.updateSpecification(specificationEntity);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteById(@PathVariable(value = "id") Long specificationId){
        if(specificationId != null) {
            this.specificationService.deleteSpecifcaitionById(specificationId);
        }
    }
}
