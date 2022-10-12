package Interfaces;

import models.*;

import java.util.Queue;

public interface CustomerInterface {

     String addToCart(Store store, Item item, Customer customer);

    String joinTheQueue(Store store, Customer customer, Queue<Customer> customerQueue);
}
