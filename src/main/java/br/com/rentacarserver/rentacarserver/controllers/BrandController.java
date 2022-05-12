package br.com.rentacarserver.rentacarserver.controllers;

import br.com.rentacarserver.rentacarserver.entities.BrandEntity;
import br.com.rentacarserver.rentacarserver.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/brand")
public class BrandController {

    private BrandRepository brandRepository;

    public BrandController(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }

    @GetMapping(path = "/allbrands")
    public List<BrandEntity> findAll(){
        return this.brandRepository.findAll();
    }

    @GetMapping(path = "/allbrands/{name}")
    public List<BrandEntity> findByName(@PathVariable(value = "name") String brandName){
        return this.brandRepository.findByName(brandName);
    }

    @PostMapping
    public void insertBrand(@RequestBody final BrandEntity brandEntity){
        try{
            this.brandRepository.save(brandEntity);
        }catch (Exception e){
            e.getMessage();
        }
    }

    @PutMapping
    public void updateBrand(@RequestBody final BrandEntity brandEntity){
        this.brandRepository.save(brandEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBrandById(@PathVariable(value = "id") Long brandId){
        if(brandId != null) {
            this.brandRepository.deleteById(brandId);
        }
    }

}
