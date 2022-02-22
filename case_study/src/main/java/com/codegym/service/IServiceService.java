package com.codegym.service;

import com.codegym.model.Service;

import java.util.List;

public interface IServiceService extends IGeneralService<Service> {
    List<Service> searchByNameAndSelect(String serviceName, String standardRoom, String rentType, String serviceType);
}
