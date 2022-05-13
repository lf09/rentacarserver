package br.com.rentacarserver.rentacarserver.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "brand")
public class BrandEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "creat_at")
    private String createdAt;

    @OneToMany(mappedBy = "brandEntity")
    private List<CarsEntity> carsEntity;

    public BrandEntity(){
    }

    public BrandEntity(Long id, String name, String createdAt){
        this.id = id;
        this.name = name;
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

    public String getCreatedAt(){
        return this.createdAt;
    }

    public void setCreatedAt( String createdAt){
        this.createdAt = createdAt;
    }
}
