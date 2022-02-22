package com.codegym.repository;

import com.codegym.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IServiceRepository extends JpaRepository<Service,Long> {
    @Query(value="SELECT * FROM service WHERE service_name LIKE :serviceName AND standard_room LIKE :standardRoom AND rent_type_id LIKE :rentType AND service_type_id LIKE :serviceType",nativeQuery = true)
    List<Service> searchByNameAndSelect(@Param("serviceName") String serviceName, @Param("standardRoom") String standardRoom, @Param("rentType") String rentType, @Param("serviceType") String serviceType);
}
