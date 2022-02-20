package com.codegym.dto;

import com.codegym.model.RentType;
import com.codegym.model.ServiceType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ServiceDto implements Validator {
    private Long serviceId;
    private String serviceCode;
    private String serviceName;
    private Integer serviceArea;
    private Long serviceCost;
    private Integer serviceMaxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloors;
    private RentType rentTypes;
    private ServiceType serviceTypes;

    public ServiceDto() {
    }

    public ServiceDto(String serviceCode, String serviceName, Integer serviceArea, Long serviceCost, Integer serviceMaxPeople, String standardRoom, String descriptionOtherConvenience, Double poolArea, Integer numberOfFloors, RentType rentTypes, ServiceType serviceTypes) {
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.rentTypes = rentTypes;
        this.serviceTypes = serviceTypes;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Long getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Long serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public RentType getRentTypes() {
        return rentTypes;
    }

    public void setRentTypes(RentType rentTypes) {
        this.rentTypes = rentTypes;
    }

    public ServiceType getServiceTypes() {
        return serviceTypes;
    }

    public void setServiceTypes(ServiceType serviceTypes) {
        this.serviceTypes = serviceTypes;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ServiceDto serviceDto = (ServiceDto) target;
        String serviceCode = serviceDto.serviceCode;
        if (!serviceCode.matches("^DV-\\d{4}$")){
            errors.rejectValue("serviceCode","serviceCode.rejected","Service Code must be format: DV-XXXX");
        }
        String serviceName = serviceDto.serviceName;
        if (!serviceName.matches("^((\\w\\s?){5,44})\\w$")){
            errors.rejectValue("serviceName","serviceName.rejected","Service Name has length from 5 to 45 characters");
        }
        Integer serviceArea = serviceDto.serviceArea;
        if (!(serviceArea >0)){
            errors.rejectValue("serviceArea","serviceArea.rejected","Service Area must be higher than 0");
        }
        Long serviceCost = serviceDto.serviceCost;
        if (!(serviceCost>0)){
            errors.rejectValue("serviceCost","serviceCost.rejected","Service Cost must be higher than 0");
        }
        Integer serviceMaxPeople = serviceDto.serviceMaxPeople;
        if (!(serviceMaxPeople>0)){
            errors.rejectValue("serviceMaxPeople","serviceMaxPeople.rejected","Service Max People must be high than 0");
        }
        String standardRoom = serviceDto.standardRoom;
        if (!standardRoom.matches("^((\\w\\s?){5,44})\\w$")){
            errors.rejectValue("standardRoom","standardRoom.rejected","Standard Room has length from 5 to 45 characters");
        }
        String otherConvenience = serviceDto.descriptionOtherConvenience;
        if (!otherConvenience.matches("^((\\w\\s?){5,254})\\w$")){
            errors.rejectValue("descriptionOtherConvenience","descriptionOtherConvenience.rejected","Other Convenience has length from 5 to 255 characters");
        }
        Double poolArea = serviceDto.poolArea;
        if (!(poolArea>0)){
            errors.rejectValue("poolArea","poolArea.rejected","Pool Area must be higher than 0");
        }
        Integer numberOfFloors = serviceDto.numberOfFloors;
        if (!(numberOfFloors>0)){
            errors.rejectValue("numberOfFloors","numberOfFloors.rejected","Floors must be higher than 0");
        }
    }
}
