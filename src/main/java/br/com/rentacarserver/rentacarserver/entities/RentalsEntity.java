package br.com.rentacarserver.rentacarserver.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rentals")
public class RentalsEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long carId;

    private Date startDate;

    private Date endDate;

    private Float total;

    private Date createdAt;

    private Date updateAt;

    @ManyToOne
    @JoinColumn(name = "cars_id")
    private CarsEntity carsEntity;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomersEntity customersEntity;

    public RentalsEntity(){

    }

    public RentalsEntity(Long id, Long carId, Date startDate, Date endDate, Float total, Date createdAt, Date updateAt) {
        this.id = id;
        this.carId = carId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.total = total;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
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

    public Date getStartDate(){
        return startDate;
    }

    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }

    public Date getEndDate(){
        return endDate;
    }

    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }

    public Float getTotal(){
        return total;
    }

    public void setTotal(Float total){
        this.total = total;
    }

    public Date getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(Date createdAt){
        this.createdAt = createdAt;
    }

    public Date getUpdateAt(){
        return  updateAt;
    }

    public void setUpdateAt(Long Up){
        this.updateAt = updateAt;
    }


}
