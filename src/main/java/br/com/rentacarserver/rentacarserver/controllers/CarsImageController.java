package br.com.rentacarserver.rentacarserver.controllers;

import br.com.rentacarserver.rentacarserver.entities.CarsImageEntity;
import br.com.rentacarserver.rentacarserver.repositories.CarsImageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path ="/carsimage")
public class CarsImageController {

    private CarsImageRepository carsImageService;

    public CarsImageController(CarsImageRepository carsImageRepository){
        this.carsImageService = carsImageRepository;
    }

    @GetMapping(path = "/allcarsimage")
    public List<CarsImageEntity> findAll(){
        return this.carsImageService.findAll();
    }

    @GetMapping(path = "/allcarsimage/{id}")
    public Optional<CarsImageEntity> findById(@PathVariable(value = "id") Long carsImageId){
        return this.carsImageService.findById(carsImageId);
    }

    @PostMapping
    public void insertCarsImage(@RequestBody final CarsImageEntity carsImageEntity){
        try{
            this.carsImageService.save(carsImageEntity);
        }catch (Exception e){
            e.getMessage();
        }
    }

    @PutMapping
    public void updateCarsImage(@RequestBody final CarsImageEntity carsImageEntity){
        this.carsImageService.save(carsImageEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable(value = "id") Long carsImageId){
        if(carsImageId != null) {
            this.carsImageService.deleteById(carsImageId);
        }
    }

}
