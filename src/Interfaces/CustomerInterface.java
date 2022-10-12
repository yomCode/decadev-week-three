package Interfaces;

import models.*;

public interface CustomerInterface {

     String buyProduct(Store store, Staff staff);

     Products addToCart(Store store, Item item, Customer customer);

}
