package br.com.rentacarserver.rentacarserver.controllers;

import br.com.rentacarserver.rentacarserver.entities.CategoriesEntity;
import br.com.rentacarserver.rentacarserver.repositories.CategoriesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/categories")
public class CategoriesController {

    private CategoriesRepository categoriesRepository;

    public CategoriesController(CategoriesRepository categoriesRepository){
        this.categoriesRepository = categoriesRepository;
    }

    @GetMapping(path = "/allcategories")
    public List<CategoriesEntity> findAll(){
        return this.categoriesRepository.findAll();
    }

    @GetMapping(path = "/allcategories/{name}")
    public List<CategoriesEntity> findByName(@PathVariable(value = "name") String brandName){
        return this.categoriesRepository.findByName(brandName);
    }

    @PostMapping
    public void insert(@RequestBody final CategoriesEntity categoriesEntity){
        try{
            this.categoriesRepository.save(categoriesEntity);
        }catch (Exception e){
            e.getMessage();
        }
    }

    @PutMapping
    public void update(@RequestBody final CategoriesEntity categoriesEntity){
        this.categoriesRepository.save(categoriesEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable(value = "id") Long categoriesId){
        if(categoriesId != null) {
            this.categoriesRepository.deleteById(categoriesId);
        }
    }
}
