package br.com.rentacarserver.rentacarserver.entities;

import br.com.rentacarserver.rentacarserver.controllers.CarsSpecificationsController;

import javax.persistence.*;

@Entity
@Table(name = "cars_specifications")
public class CarsSpecificationsEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "specification_id")
    private SpecificationEntity specificationEntity;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private CarsEntity carsEntity;

    public CarsSpecificationsEntity(){

    }

    public CarsSpecificationsEntity(Long id) {
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

}
