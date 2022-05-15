package br.com.rentacarserver.rentacarserver.services;

import br.com.rentacarserver.rentacarserver.entities.SpecificationEntity;
import br.com.rentacarserver.rentacarserver.myutils.MyUtils;
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
        if(specificationEntity.getName() != null &&
                (!specificationEntity.getName().isEmpty())){
            if(specificationEntity.getId() == null ||
                    (!this.specificationRepository.existsById(specificationEntity.getId()))){
                specificationEntity.setCreatedAt(MyUtils.timestamp);
            this.specificationRepository.save(specificationEntity);
            }else {
                throw new IllegalArgumentException("Invalid ID");
            }
        }else{
            throw new IllegalArgumentException("Name as null or empty");
        }
    }

    public void updateSpecification(@RequestBody final SpecificationEntity specificationEntity){
        if(specificationEntity.getId() != null &&
                (this.specificationRepository.existsById(specificationEntity.getId()))) {
            if(specificationEntity.getName() != null &&
                    (!specificationEntity.getName().isEmpty())) {
                specificationEntity.setCreatedAt(MyUtils.timestamp);
                this.specificationRepository.save(specificationEntity);
            }else{
                throw new IllegalArgumentException("Name can't be null");
            }
        }else{
            throw new IllegalArgumentException("Update need a valid id");
        }
    }

    public void deleteSpecifcaitionById(@PathVariable(value = "id") Long specificationId){
        if(specificationId != null &&
                (this.specificationRepository.existsById(specificationId))){
            this.specificationRepository.deleteById(specificationId);
        }else{
            throw new IllegalArgumentException("id can't be null");
        }
    }

}
