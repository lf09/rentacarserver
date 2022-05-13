package br.com.rentacarserver.rentacarserver.services;

import br.com.rentacarserver.rentacarserver.entities.SpecificationEntity;
import br.com.rentacarserver.rentacarserver.repositories.SpecificationRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SpecificationService {

    private SpecificationRepository specificationRepository;

    public SpecificationService(SpecificationRepository specificationRepository){
        this.specificationRepository = specificationRepository;
    }

    public List<SpecificationEntity> findAll(){
        return this.specificationRepository.findAll();
    }

    public List<SpecificationEntity> findByName(@PathVariable(value = "name") String brandName){
        return this.specificationRepository.findByName(brandName);
    }

    public void insertSpecification(@RequestBody final SpecificationEntity specificationEntity){
        try{
            this.specificationRepository.save(specificationEntity);
        }catch (Exception e){
            e.getMessage();
        }
    }

    public void updateSpecification(@RequestBody final SpecificationEntity specificationEntity){
        this.specificationRepository.save(specificationEntity);
    }

    public void deleteSpecifcaitionById(@PathVariable(value = "id") Long specificationId){
        if(specificationId != null) {
            this.specificationRepository.deleteById(specificationId);
        }
    }

}
