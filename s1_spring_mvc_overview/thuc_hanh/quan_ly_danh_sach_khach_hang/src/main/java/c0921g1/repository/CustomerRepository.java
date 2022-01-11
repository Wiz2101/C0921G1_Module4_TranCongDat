package c0921g1.repository;

import c0921g1.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customerList = new ArrayList<>();

    static {
        int autoIncreaseId = 0;
        customerList.add(new Customer(autoIncreaseId++, "T", "t@codegym.vn", "Da Nang"));
        customerList.add(new Customer(autoIncreaseId++, "Nhat", "nhat@codegym.vn", "Quang Tri"));
        customerList.add(new Customer(autoIncreaseId++, "Trang", "trang@codegym.vn", "Ha Noi"));
        customerList.add(new Customer(autoIncreaseId++, "Nguyen Binh Son", "son@codegym.vn", "Sai Gon"));
        customerList.add(new Customer(autoIncreaseId++, "Dang Xuan Hoa", "hoa.dang@codegym.vn", "Da Nang"));
    }

    @Override
    public List<Customer> showList() {
        return customerList;
    }

    @Override
    public Customer selectbyId(int id) {
        for (Customer cu : customerList) {
            if (cu.getId() == id) {
                return cu;
            }
        }
        return null;
    }

    @Override
    public void editCustomer(Customer customer) {
        for (Customer cu : customerList) {
            if (cu.getId() == customer.getId()) {
                cu.setName(customer.getName());
                cu.setEmail(customer.getEmail());
                cu.setAddress(customer.getAddress());
            }
        }
    }

    @Override
    public void deleteCustomer(int id) {
        for (Customer cu : customerList) {
            if (cu.getId() == id) {
                customerList.remove(cu);
                break;
            }
        }
    }


}
