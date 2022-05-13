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
    private CarsEntity carsEntity;

    public CarsImageEntity(){

    }

    public CarsImageEntity(Long id, String image, Date createdAt) {
        this.id = id;
        this.image = image;
        this.createdAt = createdAt;
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

}
