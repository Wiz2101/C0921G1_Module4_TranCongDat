package c0921g1.service;

import c0921g1.model.Customer;

import java.util.List;

public interface ICustomerService {
    public List<Customer> showList();
    public Customer selectbyId(int id);
    public void editCustomer(Customer customer);
    public void deleteCustomer(int id);

}
