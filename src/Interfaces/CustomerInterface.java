package Interfaces;

import models.*;

import java.util.PriorityQueue;

public interface CustomerInterface {

     String addToCart(Store store, Item item, Customer customer);

    String joinTheQueue(Store store, Customer customer, PriorityQueue<Customer> customerQueue);
}
