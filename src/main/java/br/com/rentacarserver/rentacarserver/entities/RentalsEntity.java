package br.com.rentacarserver.rentacarserver.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rentals")
public class RentalsEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Date startDate;

    private Date endDate;

    private Float total;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_at")
    private Date updateAt;

    @ManyToOne
    @JoinColumn(name = "cars_id")
    private CarsEntity cars_id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomersEntity customer_id;

    public RentalsEntity(){

    }

    public RentalsEntity(Long id, Date startDate, Date endDate, Float total, Date createdAt, Date updateAt, CarsEntity cars_id, CustomersEntity customer_id) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.total = total;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.cars_id = cars_id;
        this.customer_id = customer_id;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
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

    public CarsEntity getCars_id() {
        return cars_id;
    }

    public void setCars_id(CarsEntity cars_id) {
        this.cars_id = cars_id;
    }

    public CustomersEntity getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(CustomersEntity customer_id) {
        this.customer_id = customer_id;
    }

}
