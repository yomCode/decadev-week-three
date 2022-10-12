package Interfaces;

import models.Staff;
import models.Store;

public interface CashierInterface {

     String sellProductBasedOnQuantity(Store store, Staff staff);

     String sellProductFIFO(Store store, Staff staff);


}
