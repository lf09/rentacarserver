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
    private BrandEntity brand_id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoriesEntity category_id;

    @OneToMany(mappedBy = "car_id")
    private List<CarsImageEntity> carsImageEntity;

    @OneToMany(mappedBy = "car_id")
    private List<CarsSpecificationsEntity> carsSpecificationsEntity;

    @OneToMany(mappedBy = "cars_id")
    private List<RentalsEntity> rentalsEntity;

    public CarsEntity(){

    }

    public CarsEntity(Long id, String name, String description, Float dailyRate, String avaliable, String licensePlate, String color, Date createdAt, CategoriesEntity categoriesEntity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dailyRate = dailyRate;
        this.avaliable = avaliable;
        this.licensePlate = licensePlate;
        this.color = color;
        this.createdAt = createdAt;
        this.category_id = categoriesEntity;
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

    public BrandEntity getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(BrandEntity brand_id) {
        this.brand_id = brand_id;
    }

    public CategoriesEntity getCategory_id() {
        return category_id;
    }

    public void setCategory_id(CategoriesEntity category_id) {
        this.category_id = category_id;
    }
}
