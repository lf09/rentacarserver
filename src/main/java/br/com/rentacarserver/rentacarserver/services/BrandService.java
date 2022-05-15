package br.com.rentacarserver.rentacarserver.services;

import br.com.rentacarserver.rentacarserver.entities.BrandEntity;
import br.com.rentacarserver.rentacarserver.repositories.BrandRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Instant;
import java.util.List;

@Service
public class BrandService {

    private BrandRepository brandRepository;
    protected Instant dateNow = Instant.now();

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
            if(brandEntity.getName() != null &&
                    (!brandEntity.getName().isEmpty())){
                if(brandEntity.getId() == null ||
                        (!this.brandRepository.existsById(brandEntity.getId()))){
                    brandEntity.setCreatedAt(dateNow.getEpochSecond());
                    this.brandRepository.save(brandEntity);
                }else {
                    throw new IllegalArgumentException("Invalid ID");
                }
            }else{
                throw new IllegalArgumentException("Name as null or empty");
            }
    }

    public void updateBrand(@RequestBody final BrandEntity brandEntity){
        if(brandEntity.getId() != null &&
                (this.brandRepository.existsById(brandEntity.getId()))) {
            if(brandEntity.getName() != null &&
                (!brandEntity.getName().isEmpty())) {
                brandEntity.setCreatedAt(dateNow.getEpochSecond());
                this.brandRepository.save(brandEntity);
            }else{
                throw new IllegalArgumentException("Name can't be null");
            }
        }else{
            throw new IllegalArgumentException("Update need a valid id");
        }
    }

    public void deleteBrandById(@PathVariable(value = "id") Long brandId){
        if(brandId != null &&
                (this.brandRepository.existsById(brandId))){
            this.brandRepository.deleteById(brandId);
        }else{
            throw new IllegalArgumentException("id can't be null");
        }
    }

}
