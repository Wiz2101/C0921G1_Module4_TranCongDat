package com.codegym.dto;

import com.codegym.model.Division;
import com.codegym.model.EducationDegree;
import com.codegym.model.Position;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EmployeeDto implements Validator {
    private Long employeeId;
    private String employeeName;
    private String employeeBirthday;
    private String employeeIdCard;
    private Long employeeSalary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;
    private Position positions;
    private EducationDegree educationDegrees;
    private Division divisions;

    public EmployeeDto() {
    }

    public EmployeeDto(String employeeName, String employeeBirthday, String employeeIdCard, Long employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, Position positions, EducationDegree educationDegrees, Division divisions) {
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.positions = positions;
        this.educationDegrees = educationDegrees;
        this.divisions = divisions;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Long getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Long employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPositions() {
        return positions;
    }

    public void setPositions(Position positions) {
        this.positions = positions;
    }

    public EducationDegree getEducationDegrees() {
        return educationDegrees;
    }

    public void setEducationDegrees(EducationDegree educationDegrees) {
        this.educationDegrees = educationDegrees;
    }

    public Division getDivisions() {
        return divisions;
    }

    public void setDivisions(Division divisions) {
        this.divisions = divisions;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        String employeeName = employeeDto.employeeName;
        if (!employeeName.matches("^((\\w\\s?){5,44})\\w$")){
            errors.rejectValue("employeeName", "employeeName.rejected","Employee Name has length from 5 to 45 characters");
        }
        String employeeIdCard = employeeDto.employeeIdCard;
        if (!employeeIdCard.matches("^\\d{9}$")){
            errors.rejectValue("employeeIdCard","employeeIdCard.rejected","Employee IdCard must has 9 digits only");
        }
        Long employeeSalary = employeeDto.employeeSalary;
        if (!(employeeSalary>0)){
            errors.rejectValue("employeeSalary","employeeSalary.rejected","Employee Salary must be higher than 0");
        }
        String employeePhone = employeeDto.employeePhone;
        if (!employeePhone.matches("^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$")){
            errors.rejectValue("employeePhone","employeePhone.rejected","Employee Phone must be format: [090/091/(84)+90/(84)+91]XXXXXXX");
        }
        String employeeEmail = employeeDto.employeeEmail;
        if (!employeeEmail.matches("^((\\w|\\.|\\_){5,45})\\@\\w{5,10}\\.\\w{2,5}$")){
            errors.rejectValue("employeeEmail","employeeEmail.rejected","Employee Email must be format: example@domain.com");
        }
        String employeeAddress = employeeDto.employeeAddress;
        if (!employeeAddress.matches("^((\\w\\s?){5,254})\\w$")){
            errors.rejectValue("employeeAddress","employeeAddress.rejected","Employee Address has length from 5 to 255 characters");
        }
    }
}
