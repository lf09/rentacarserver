package br.com.rentacarserver.rentacarserver.services;

import br.com.rentacarserver.rentacarserver.entities.BrandEntity;
import br.com.rentacarserver.rentacarserver.repositories.BrandRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BrandService {

    private BrandRepository brandRepository;

    public BrandService( BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }

    public List<BrandEntity> findAll(){
        return this.brandRepository.findAll();
    }

    public List<BrandEntity> findByName(@PathVariable(value = "name") String brandName){
        return this.brandRepository.findByName(brandName);
    }

    public void insertBrand(@RequestBody final BrandEntity brandEntity){
        try{
            if(brandEntity.getName() != null && (
                    !brandEntity.getName().isEmpty())){
                this.brandRepository.save(brandEntity);
            }
        }catch (Exception e){
            e.getMessage();
        }
    }

    public void updateBrand(@RequestBody final BrandEntity brandEntity){
        this.brandRepository.save(brandEntity);
    }

    public void deleteBrandById(@PathVariable(value = "id") Long brandId){
        if(brandId != null) {
            this.brandRepository.deleteById(brandId);
        }
    }

}
