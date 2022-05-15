package br.com.rentacarserver.rentacarserver.services;

import br.com.rentacarserver.rentacarserver.entities.CarsEntity;
import br.com.rentacarserver.rentacarserver.myutils.MyUtils;
import br.com.rentacarserver.rentacarserver.repositories.CarsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CarsService {

    private CarsRepository carsRepository;

    public CarsService(CarsRepository brandRepository){
        this.carsRepository = brandRepository;
    }

    public List<CarsEntity> findAll(){
        return this.carsRepository.findAll();
    }

    public List<CarsEntity> findByName(@PathVariable(value = "name") String carsName){
        return this.carsRepository.findByName(carsName);
    }

    public void insertCars(@RequestBody final CarsEntity carsEntity){
        if(carsEntity.getName() != null &&
                (!carsEntity.getName().isEmpty())){
            if(carsEntity.getId() == null ||
                    (!this.carsRepository.existsById(carsEntity.getId()))){
                carsEntity.setCreatedAt(MyUtils.timestamp);
                this.carsRepository.save(carsEntity);
            }else {
                throw new IllegalArgumentException("Invalid ID");
            }
        }else{
            throw new IllegalArgumentException("Name as null or empty");
        }
    }

    public void updateCars(@RequestBody final CarsEntity carsEntity){
        if(carsEntity.getId() != null &&
                (this.carsRepository.existsById(carsEntity.getId()))) {
            if(carsEntity.getName() != null &&
                    (!carsEntity.getName().isEmpty())) {
                carsEntity.setCreatedAt(MyUtils.timestamp);
                this.carsRepository.save(carsEntity);
            }else{
                throw new IllegalArgumentException("Name can't be null");
            }
        }else{
            throw new IllegalArgumentException("Update need a valid id");
        }
    }

    public void deleteCarsById(@PathVariable(value = "id") Long carsId){
        if(carsId != null &&
                (this.carsRepository.existsById(carsId))){
                this.carsRepository.deleteById(carsId);
        }else{
            throw new IllegalArgumentException("id can't be null");
        }
    }

}
