package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.NotNull;
public class UserDto implements Validator {
    Long id;
    String firstName;
    String lastName;
    String phoneNumber;
    @NotNull (message = "Minimum age is 18")
    Integer age;
    String email;

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, String phoneNumber, Integer age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        String firstName = userDto.getFirstName();
        if (!firstName.matches("^\\w{5,45}$")) {
            errors.rejectValue("firstName", "firstName.rejected", "First Name must has minimum length 5, maximum 45 characters");
        }

        String lastName = userDto.getLastName();
        if (!lastName.matches("^\\w{5,45}$")) {
            errors.rejectValue("lastName", "lastName.rejected", "Last Name must has minimum length 5, maximum 45 characters");
        }

        String phoneNumber = userDto.getPhoneNumber();
        if (!phoneNumber.matches("^0\\d{9}$")) {
            errors.rejectValue("phoneNumber", "phoneNumber.rejected", "Phone Number must has 10 digits and begin with 0");
        }

        Integer age = userDto.getAge();
        if (!(age >= 18)) {
            errors.rejectValue("age", "age.rejected", "Age must higher than 18");
        }

        String email = userDto.getEmail();
        if (!email.matches("^([\\w._-]+){5,20}@\\w+.\\w+$")) {
            errors.rejectValue("email", "email.rejected", "Email must has at least 5 and maximum 5 characters");
        }

    }
}
