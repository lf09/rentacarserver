package br.com.rentacarserver.rentacarserver.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cars_image")
public class CarsImageEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String image;

    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private CarsEntity car_id;

    public CarsImageEntity(){

    }

    public CarsImageEntity(Long id, String image, Date createdAt, CarsEntity cars_id) {
        this.id = id;
        this.image = image;
        this.createdAt = createdAt;
        this.car_id = cars_id;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getImage(){
        return image;
    }

    public void setImage(String image){
        this.image = image;
    }

    public Date getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(Date createdAt){
        this.createdAt = createdAt;
    }

    public CarsEntity getCar_id() {
        return car_id;
    }

    public void setCar_id(CarsEntity car_id) {
        this.car_id = car_id;
    }

}
