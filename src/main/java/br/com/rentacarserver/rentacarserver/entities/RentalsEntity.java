package br.com.rentacarserver.rentacarserver.entities;

import javax.persistence.*;
import javax.swing.event.MenuDragMouseEvent;
import java.util.Date;

@Entity
@Table(name = "rentals")
public class RentalsEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long carId;

    private Long customerId;

    private Date startDate;

    private Date endDate;

    private Float total;

    private Date createdAt;

    private Date updateAt;

    public RentalsEntity(){

    }

    public RentalsEntity(Long id, Long carId, Long customerId, Date startDate, Date endDate, Float total, Date createdAt, Date updateAt) {
        this.id = id;
        this.carId = carId;
        this.customerId = customerId;
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

    public Long getCustomerId(){
        return customerId;
    }

    public void setCustomerId(Long customerId){
        this.customerId = customerId;
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
