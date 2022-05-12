package br.com.rentacarserver.rentacarserver.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "specification")
public class SpecificationEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false )
    private String name;

    private String description;

    private Date createdAt;

    public SpecificationEntity(){

    }

    public SpecificationEntity(Long id, String name, String description, Date createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
    }

    public Long getId(){
        return id;
    }

    public void set(Long id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Date getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(Date createdAt){
        this.createdAt = createdAt;
    }
}