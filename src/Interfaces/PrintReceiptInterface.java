package Interfaces;

import models.Customer;
import models.Staff;
import models.Store;

public interface PrintReceiptInterface {
     String printReceipt(Store store, Staff staff, Customer customer);
}
