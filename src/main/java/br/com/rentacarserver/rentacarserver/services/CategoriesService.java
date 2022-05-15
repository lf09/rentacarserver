package br.com.rentacarserver.rentacarserver.services;

import br.com.rentacarserver.rentacarserver.entities.CategoriesEntity;
import br.com.rentacarserver.rentacarserver.myutils.MyUtils;
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

    public void insertCategories(@RequestBody final CategoriesEntity categoriesEntity){
        if(categoriesEntity.getName() != null &&
                (!categoriesEntity.getName().isEmpty())){
            if(categoriesEntity.getId() == null ||
                    (!this.categoriesRepository.existsById(categoriesEntity.getId()))){
                categoriesEntity.setCreatedAt(MyUtils.timestamp);
            this.categoriesRepository.save(categoriesEntity);
            }else {
                throw new IllegalArgumentException("Invalid ID");
            }
        }else{
            throw new IllegalArgumentException("Name as null or empty");
        }
    }

    public void updateCategories(@RequestBody final CategoriesEntity categoriesEntity){
        if(categoriesEntity.getId() != null &&
                (this.categoriesRepository.existsById(categoriesEntity.getId()))) {
            if(categoriesEntity.getName() != null &&
                    (!categoriesEntity.getName().isEmpty())) {
                categoriesEntity.setCreatedAt(MyUtils.timestamp);
                this.categoriesRepository.save(categoriesEntity);
            }else{
                throw new IllegalArgumentException("Name can't be null");
            }
        }else{
            throw new IllegalArgumentException("Update need a valid id");
        }
    }

    public void deleteBrandById(@PathVariable(value = "id") Long categoriesId){
        if(categoriesId != null &&
                (this.categoriesRepository.existsById(categoriesId))){
            this.categoriesRepository.deleteById(categoriesId);
        }else{
            throw new IllegalArgumentException("id can't be null");
        }
    }

}
