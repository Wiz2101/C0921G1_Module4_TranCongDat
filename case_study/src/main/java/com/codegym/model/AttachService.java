package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "attach_service")
public class AttachService {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long attachServiceId;
    private String attachServiceName;
    private Long attachServiceCost;
    private Integer attachServiceUnit;
    private String attachServiceStatus;

    @OneToMany (mappedBy = "attachServices")
    private List<ContractDetail> contractDetails;

    public AttachService() {
    }

    public AttachService(String attachServiceName, Long attachServiceCost, Integer attachServiceUnit, String attachServiceStatus, List<ContractDetail> contractDetails) {
        this.attachServiceName = attachServiceName;
        this.attachServiceCost = attachServiceCost;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceStatus = attachServiceStatus;
        this.contractDetails = contractDetails;
    }

    public Long getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(Long attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public Long getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(Long attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public Integer getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(Integer attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
