package br.com.rentacarserver.rentacarserver.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cars")
public class CarsEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    private String description;

    private Float dailyRate;

    private String avaliable;

    private String licensePlate;

    private String color;

    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandEntity brandEntity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoriesEntity categoryId;

    @OneToMany(mappedBy = "carsEntity")
    private List<CarsImageEntity> carsImageEntity;

    @OneToMany(mappedBy = "carsEntity")
    private List<CarsSpecificationsEntity> carsSpecificationsEntity;

    @OneToMany(mappedBy = "carsEntity")
    private List<RentalsEntity> rentalsEntity;

    public CarsEntity(){

    }

    public CarsEntity(Long id, String name, String description, Float dailyRate, String avaliable, String licensePlate, String color, Date createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dailyRate = dailyRate;
        this.avaliable = avaliable;
        this.licensePlate = licensePlate;
        this.color = color;
        this.createdAt = createdAt;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Float getDailyRate(){
        return dailyRate;
    }

    public void setDailyRate(Float dailyRate){
        this.dailyRate = dailyRate;
    }

    public String getAvaliable(){
        return avaliable;
    }

    public void setAvaliable(String avaliable){
        this.avaliable = avaliable;
    }

    public String getLicensePlate(){
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate){
        this.licensePlate = licensePlate;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public Date getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(Date createdAt){
        this.createdAt = createdAt;
    }
}
