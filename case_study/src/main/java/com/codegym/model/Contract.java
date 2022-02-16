package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long contractId;
    private String contractStartDate;
    private String contractEndDate;
    private Long contractDeposit;
    private Long contractTotalMoney;
    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "employeeId")
    private Employee employees;

    @OneToMany (mappedBy = "contracts")
    private List<ContractDetail> contractDetails;

    @ManyToOne
    @JoinColumn (name = "customer_id", referencedColumnName = "customerId")
    private Customer customers;

    @ManyToOne
    @JoinColumn (name = "service_id", referencedColumnName = "serviceId")
    private Service services;

    public Contract() {
    }

    public Contract(String contractStartDate, String contractEndDate, Long contractDeposit, Long contractTotalMoney, Employee employees, List<ContractDetail> contractDetails, Customer customers, Service services) {
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.employees = employees;
        this.contractDetails = contractDetails;
        this.customers = customers;
        this.services = services;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Long getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(Long contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Long getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(Long contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Employee getEmployees() {
        return employees;
    }

    public void setEmployees(Employee employees) {
        this.employees = employees;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }

    public Service getServices() {
        return services;
    }

    public void setServices(Service services) {
        this.services = services;
    }
}
