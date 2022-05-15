package br.com.rentacarserver.rentacarserver.controllers;

import br.com.rentacarserver.rentacarserver.entities.BrandEntity;
import br.com.rentacarserver.rentacarserver.services.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity insertBrand(@RequestBody final BrandEntity brandEntity){
        try{
            this.brandService.insertBrand(brandEntity);
            return new ResponseEntity(HttpStatus.CREATED);
        }catch (Exception e){
            e.getMessage();
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping
    public ResponseEntity updateBrand(@RequestBody final BrandEntity brandEntity){
        try{
            this.brandService.updateBrand(brandEntity);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            e.getMessage();
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBrandById(@PathVariable(value = "id") Long brandId){
        try{
            this.brandService.deleteBrandById(brandId);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            e.getMessage();
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
