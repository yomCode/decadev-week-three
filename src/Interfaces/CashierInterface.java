package Interfaces;

import models.Customer;
import models.Staff;
import models.Store;

public interface CashierInterface {

     String sellProduct(Store store, Staff staff, Customer customer);


}
