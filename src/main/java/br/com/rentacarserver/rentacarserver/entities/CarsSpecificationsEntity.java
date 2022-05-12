package br.com.rentacarserver.rentacarserver.entities;

import br.com.rentacarserver.rentacarserver.controllers.CarsSpecificationsController;

import javax.persistence.*;

@Entity
@Table(name = "cars_specifications")
public class CarsSpecificationsEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long carId;

    private Long specificationId;

    public CarsSpecificationsEntity(){

    }

    public CarsSpecificationsEntity(Long id, Long carId, Long specificationId) {
        this.id = id;
        this.carId = carId;
        this.specificationId = specificationId;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getCarId(){
        return carId;
    }

    public void setCarId(Long carId){
        this.carId = carId;
    }

    public Long getSpecificationId(){
        return specificationId;
    }

    public void setSpecificationId(Long specificationId){
        this.specificationId = specificationId;
    }
}
