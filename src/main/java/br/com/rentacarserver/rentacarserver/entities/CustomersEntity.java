package br.com.rentacarserver.rentacarserver.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customers")
public class CustomersEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    private Date birthDate;

    private String email;

    private String driverLicense;

    private String address;

    private String phoneNumber;

    private Date createdAt;

    private Date updateAt;

    public CustomersEntity(){

    }

    public CustomersEntity(Long id, String name, Date birthDate, String email, String driverLicense, String address, String phoneNumber, Date createdAt, Date updateAt) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.driverLicense = driverLicense;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
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

    public Date getBirthDate(){
        return birthDate;
    }

    public void setBirthDate(Date birthDate){
        this.birthDate = birthDate;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getDriverLicense(){
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense){
        this.driverLicense = driverLicense;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public Date getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(Date createdAt){
        this.createdAt = createdAt;
    }

    public Date getUpdateAt(){
        return updateAt;
    }
}
