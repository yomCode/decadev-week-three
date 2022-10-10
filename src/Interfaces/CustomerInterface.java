package Interfaces;

import models.Customer;
import models.Item;
import models.Products;
import models.Store;

public interface CustomerInterface {

     String buyProduct(Store store, Customer customer);

     Products addToCart(Store store, Item item, Customer customer);

}
