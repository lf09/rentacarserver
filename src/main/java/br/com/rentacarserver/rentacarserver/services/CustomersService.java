package br.com.rentacarserver.rentacarserver.services;

import br.com.rentacarserver.rentacarserver.entities.CustomersEntity;
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

    public void insertBrand(@RequestBody final CustomersEntity customersEntity){
        try{
            this.customersRepository.save(customersEntity);
        }catch (Exception e){
            e.getMessage();
        }
    }

    public void updateCustomers(@RequestBody final CustomersEntity customersEntity){
        this.customersRepository.save(customersEntity);
    }

    public void deleteCustomersById(@PathVariable(value = "id") Long customersId){
        if(customersId != null) {
            this.customersRepository.deleteById(customersId);
        }
    }

}
