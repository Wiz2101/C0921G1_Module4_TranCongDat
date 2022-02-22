package com.codegym.dto;

import com.codegym.model.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

public class CustomerDto implements Validator {
    private Long customerId;
    @NotBlank
    private String customerCode;
    @NotBlank
    private String customerName;
    @NotBlank
    private String customerBirthday;
    @NotBlank
    private String customerGender;
    @NotBlank
    private String customerIdCard;
    @NotBlank
    private String customerPhone;
    @NotBlank
    private String customerEmail;
    @NotBlank
    private String customerAddress;
    @NotBlank
    private CustomerType customerTypes;

    public CustomerDto() {
    }

    public CustomerDto(String customerCode, String customerName, String customerBirthday, String customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress, CustomerType customerTypes) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerTypes = customerTypes;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerTypes() {
        return customerTypes;
    }

    public void setCustomerTypes(CustomerType customerTypes) {
        this.customerTypes = customerTypes;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        String customerCode = customerDto.customerCode;
        if (!customerCode.matches("^KH-\\d{4}$")){
            errors.rejectValue("customerCode", "customerCode.rejected", "Customer Code must be format: KH-XXXX");
        }
        String customerName = customerDto.customerName;
        if (!customerName.matches("^((\\w\\s?){5,44})\\w$")){
            errors.rejectValue("customerName", "customerName.rejected","Customer Name has length from 5 to 45 characters");
        }
        String customerIdCard = customerDto.customerIdCard;
        if (!customerIdCard.matches("^\\d{9}$")){
            errors.rejectValue("customerIdCard","customerIdCard.rejected","Customer IdCard must has 9 digits only");
        }
        String customerPhone = customerDto.customerPhone;
        if (!customerPhone.matches("^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$")){
            errors.rejectValue("customerPhone","customerPhone.rejected","Customer Phone must be format: [090/091/(84)+90/(84)+91]XXXXXXX");
        }
        String customerEmail = customerDto.customerEmail;
        if (!customerEmail.matches("^((\\w|\\.|\\_){5,45})\\@\\w{5,10}\\.\\w{2,5}$")){
            errors.rejectValue("customerEmail","customerEmail.rejected","Customer Email must be format: example@domain.com");
        }
        String customerAddress = customerDto.customerAddress;
        if (!customerAddress.matches("^((\\w\\s?){5,254})\\w$")){
            errors.rejectValue("customerAddress","customerAddress.rejected","Customer Address has length from 5 to 255 characters");
        }
    }
}
