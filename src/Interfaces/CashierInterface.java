package Interfaces;

import models.Customer;
import models.Staff;
import models.Store;
import services.CustomerServiceImpl;

public interface CashierInterface {

     String sellProduct(Store store, Staff staff, Customer customer, CustomerServiceImpl customerService);


}
