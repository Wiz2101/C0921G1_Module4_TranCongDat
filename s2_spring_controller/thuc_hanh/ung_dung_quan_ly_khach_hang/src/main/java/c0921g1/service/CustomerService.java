package c0921g1.service;

import c0921g1.model.Customer;
import c0921g1.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public List<Customer> showList() {
        return customerRepository.showList();
    }

    @Override
    public Customer selectbyId(int id) {
        return customerRepository.selectbyId(id);
    }

    @Override
    public void editCustomer(Customer customer) {
        customerRepository.editCustomer(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteCustomer(id);
    }


}
