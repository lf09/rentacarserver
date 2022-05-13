package br.com.rentacarserver.rentacarserver.services;

import br.com.rentacarserver.rentacarserver.entities.CategoriesEntity;
import br.com.rentacarserver.rentacarserver.repositories.CategoriesRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CategoriesService {

    private CategoriesRepository categoriesRepository;

    public CategoriesService(CategoriesRepository categoriesRepository){
        this.categoriesRepository = categoriesRepository;
    }

    public List<CategoriesEntity> findAll(){
        return this.categoriesRepository.findAll();
    }

    public List<CategoriesEntity> findByName(@PathVariable(value = "name") String categoriesName){
        return this.categoriesRepository.findByName(categoriesName);
    }

    public void insertBrand(@RequestBody final CategoriesEntity categoriesEntity){
        try{
            this.categoriesRepository.save(categoriesEntity);
        }catch (Exception e){
            e.getMessage();
        }
    }

    public void updateBrand(@RequestBody final CategoriesEntity categoriesEntity){
        this.categoriesRepository.save(categoriesEntity);
    }

    public void deleteBrandById(@PathVariable(value = "id") Long categoriesId){
        if(categoriesId != null) {
            this.categoriesRepository.deleteById(categoriesId);
        }
    }

}
