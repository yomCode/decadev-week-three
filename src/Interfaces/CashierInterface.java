package Interfaces;

import models.Customer;
import models.Staff;
import models.Store;

import java.util.Queue;

public interface CashierInterface {

     String sellProduct(Store store, Staff staff, Queue<Customer> customerQueue);



}
