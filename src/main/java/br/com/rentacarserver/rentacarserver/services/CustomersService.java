package br.com.rentacarserver.rentacarserver.services;

import br.com.rentacarserver.rentacarserver.entities.CustomersEntity;
import br.com.rentacarserver.rentacarserver.myutils.MyUtils;
import br.com.rentacarserver.rentacarserver.repositories.CustomersRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CustomersService {

    private CustomersRepository customersRepository;

    public CustomersService(CustomersRepository customersRepository){
        this.customersRepository = customersRepository;
    }

    public List<CustomersEntity> findAll(){
        return this.customersRepository.findAll();
    }

    public List<CustomersEntity> findByName(@PathVariable(value = "name") String customersName){
        return this.customersRepository.findByName(customersName);
    }

    public void insertCustomers(@RequestBody final CustomersEntity customersEntity){
        if(customersEntity.getName() != null &&
                (!customersEntity.getName().isEmpty())){
            if(customersEntity.getId() == null ||
                    (!this.customersRepository.existsById(customersEntity.getId()))){
                customersEntity.setCreatedAt(MyUtils.timestamp);
                this.customersRepository.save(customersEntity);
            }else {
                throw new IllegalArgumentException("Invalid ID");
            }
        }else{
            throw new IllegalArgumentException("Name as null or empty");
        }
    }

    public void updateCustomers(@RequestBody final CustomersEntity customersEntity){
        if(customersEntity.getId() != null &&
                (this.customersRepository.existsById(customersEntity.getId()))) {
            if(customersEntity.getName() != null &&
                    (!customersEntity.getName().isEmpty())) {
                customersEntity.setUpdateAt(MyUtils.timestamp);
                this.customersRepository.save(customersEntity);
            }else{
                throw new IllegalArgumentException("Name can't be null");
            }
        }else{
            throw new IllegalArgumentException("Update need a valid id");
        }
    }

    public void deleteCustomersById(@PathVariable(value = "id") Long customersId){
        if(customersId != null &&
                (this.customersRepository.existsById(customersId))){
            this.customersRepository.deleteById(customersId);
        }else{
            throw new IllegalArgumentException("id can't be null");
        }
    }

}
