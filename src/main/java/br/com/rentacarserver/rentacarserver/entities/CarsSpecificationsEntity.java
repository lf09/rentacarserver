package br.com.rentacarserver.rentacarserver.entities;

import javax.persistence.*;

@Entity
@Table(name = "cars_specifications")
public class CarsSpecificationsEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private CarsEntity car_id;

    @ManyToOne
    @JoinColumn(name = "specification_id")
    private SpecificationEntity specification_id;

    public CarsSpecificationsEntity(){

    }

    public CarsSpecificationsEntity(Long id, CarsEntity car_id, SpecificationEntity specification_id) {
        this.id = id;
        this.car_id = car_id;
        this.specification_id = specification_id;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public CarsEntity getCar_id() {
        return car_id;
    }

    public void setCar_id(CarsEntity car_id) {
        this.car_id = car_id;
    }

    public SpecificationEntity getSpecification_id() {
        return specification_id;
    }

    public void setSpecification_id(SpecificationEntity specification_id) {
        this.specification_id = specification_id;
    }

}
