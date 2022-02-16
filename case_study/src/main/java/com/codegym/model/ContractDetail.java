package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail")
public class ContractDetail {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long contractDetailId;
    private Integer quantity;
    @ManyToOne
    @JoinColumn (name = "contract_id", referencedColumnName = "contractId")
    private Contract contracts;

    @ManyToOne
    @JoinColumn (name = "attach_service_id", referencedColumnName = "attachServiceId")
    private AttachService attachServices;

    public ContractDetail() {
    }

    public ContractDetail(Integer quantity, Contract contracts, AttachService attachServices) {
        this.quantity = quantity;
        this.contracts = contracts;
        this.attachServices = attachServices;
    }

    public Long getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Long contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Contract getContracts() {
        return contracts;
    }

    public void setContracts(Contract contracts) {
        this.contracts = contracts;
    }

    public AttachService getAttachServices() {
        return attachServices;
    }

    public void setAttachServices(AttachService attachServices) {
        this.attachServices = attachServices;
    }
}
