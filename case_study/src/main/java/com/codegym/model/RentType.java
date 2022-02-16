package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rent_type")
public class RentType {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long rentTypeId;
    private String rentTypeName;
    private Long rentTypeCost;

    @OneToMany (mappedBy = "rentTypes")
    private List<Service> services;

    public RentType() {
    }

    public RentType(String rentTypeName, Long rentTypeCost, List<Service> services) {
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
        this.services = services;
    }

    public Long getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Long rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public Long getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(Long rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
