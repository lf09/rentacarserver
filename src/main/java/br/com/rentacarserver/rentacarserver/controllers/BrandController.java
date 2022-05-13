package br.com.rentacarserver.rentacarserver.controllers;

import br.com.rentacarserver.rentacarserver.entities.BrandEntity;
import br.com.rentacarserver.rentacarserver.services.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/brand")
public class BrandController {

    private BrandService brandService;

    public BrandController(BrandService brandService){
        this.brandService= brandService;
    }

    @GetMapping(path = "/allbrands")
    public List<BrandEntity> findAll(){
        return this.brandService.findAll();
    }

    @GetMapping(path = "/allbrands/{name}")
    public List<BrandEntity> findByName(@PathVariable(value = "name") String brandName){
        return this.brandService.findByName(brandName);
    }

    @PostMapping
    @ResponseStatus (code = HttpStatus.CREATED)
    public void insertBrand(@RequestBody final BrandEntity brandEntity){
        try{
            this.brandService.insertBrand(brandEntity);
        }catch (Exception e){
            e.getMessage();
        }
    }

    @PutMapping
    public void updateBrand(@RequestBody final BrandEntity brandEntity){
        this.brandService.updateBrand(brandEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBrandById(@PathVariable(value = "id") Long brandId){
        if(brandId != null) {
            this.brandService.deleteBrandById(brandId);
        }
    }

}
