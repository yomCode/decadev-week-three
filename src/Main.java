
import enums.Qualification;
import enums.Role;
import enums.Sex;
import models.*;
import services.CashierServiceImpl;
import services.CustomerServiceImpl;
import services.ManagerServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;


public class Main {
    public static void main(String[] args) throws IOException {

        //Instances of a staff Class------------------------------------------------------------------------------------------->
        Staff staff1 = new Staff( 12,"Hakeem Adewale", 45, Sex.MALE, Qualification.MSC, "Adewale@gmail.com", Role.MANAGER);
        Staff staff2 = new Staff ( 323, "Adeola Johnson", 20, Sex.FEMALE, Qualification.BSC, "Adeola123@gmail.com", Role.CASHIER);
        Staff staff3 = new Staff(324, "Alex Austin",23, Sex.MALE, Qualification.HND, "alex123@gmail.com", Role.CASHIER);

        ManagerServiceImpl manager = new ManagerServiceImpl();
        CashierServiceImpl cashier = new CashierServiceImpl();

        //Instances of Applicants-------------------------------------------------------------------------------------------------
        Applicant applicant1 = new Applicant(2332, "Ronke George", 26, Sex.FEMALE, Qualification.HND,
                "rony123@gmail.com", 86.0, 3);

        Applicant applicant2 = new Applicant(2322, "John Banks", 25, Sex.MALE, Qualification.BSC,
                "john123@gmail.com", 83.5, 3);

        //Instance of the Store-----------------------------------------------------------------------------
        Store store1 = new Store(212, "Ugo Mini Store");


        //CALL THE METHOD TO READ PRODUCT FILE-----------------------------------------------------------------
        ProductFileReaderService read = new ProductFileReaderService();
        store1.setProductsList(read.productList());


        //Customer instances-------------------------------------------------------------------------------------
        ArrayList<Item> cartProduct = new ArrayList<>();
        ArrayList<Item> cartProduct1 = new ArrayList<>();
        ArrayList<Item> cartProduct2 = new ArrayList<>();
        ArrayList<Item> cartProduct3 = new ArrayList<>();


        Customer customer1 = new Customer(1,cartProduct, 100000.0);
        Customer customer2 = new Customer(2, cartProduct1, 50000.0);
        Customer customer3 = new Customer(3, cartProduct2, 20000.0);
        Customer customer4 = new Customer(4, cartProduct3, 300000.0);


        CustomerServiceImpl customerService = new CustomerServiceImpl();

        //Add items to customer1 Cart-------------------------------------------------------------------------
        Item item1 = new Item("milo", 30);
        Item item2 = new Item("monster", 5);
        Item item3 = new Item("orijin", 2);
        Item item4 = new Item("tissue paper", 20);

        customerService.addToCart(store1, item1, customer1);
        customerService.addToCart(store1, item2, customer1);
        customerService.addToCart(store1, item3, customer1);
        customerService.addToCart(store1, item4, customer1);

        //Add items to customer2 Cart-------------------------------------------------------------------------
        Item item5 = new Item("milk", 30);
        Item item6 = new Item("spoon", 15);
        Item item7 = new Item("knife", 2);
        Item item8 = new Item("sugar", 25);

        customerService.addToCart(store1, item5, customer2);
        customerService.addToCart(store1, item6, customer2);
        customerService.addToCart(store1, item7, customer2);
        customerService.addToCart(store1, item8, customer2);

        //Add items to customer3 Cart-------------------------------------------------------------------------
        Item item9 = new Item("sanitary pad", 5);
        Item item10 = new Item("orijin", 10);
        Item item11 = new Item("milk", 5);
        Item item12 = new Item("peeler", 2);

        customerService.addToCart(store1, item9, customer3);
        customerService.addToCart(store1, item10, customer3);
        customerService.addToCart(store1, item11, customer3);
        customerService.addToCart(store1, item12, customer3);

        Item item13 = new Item("5alive", 25);
        Item item14 = new Item("monster", 10);
        Item item15 = new Item("milk", 5);
        Item item16 = new Item("peeler", 1);

        customerService.addToCart(store1, item13, customer4);
        customerService.addToCart(store1, item14, customer4);
        customerService.addToCart(store1, item15, customer4);
        customerService.addToCart(store1, item16, customer4);



        //Setting the Array values to customers Cart-----------------------------------------------------------------------------------
        customer1.setPurchaseCart(cartProduct);
        customer2.setPurchaseCart(cartProduct1);
        customer3.setPurchaseCart(cartProduct2);

        //Adding the customers to Priority Queue which is a field in the Store entity (Position in the queue is determined by the number of total quantity)---
        PriorityQueue<Customer> customerQueue = new PriorityQueue<>(store1);


        customerQueue.add(customer1);
        customerQueue.add(customer2);
        customerQueue.add(customer3);
        customerQueue.add(customer4);

        store1.setCustomerQueue(customerQueue);



//        for(Products product : store1.getProductsList()){
//            System.out.println(product);
//        }


        System.out.println(cashier.sellProduct(store1, staff2));

//        for(Customer queue: store1.getCustomerQueue()){
//            System.out.println(queue);
//        }

//        for(Products product : store1.getProductsList()){
//            System.out.println(product);
//        }

        System.out.println("Customer 2 " + customer2.getTotalCartQty());
        System.out.println("Customer 1 " + customer1.getTotalCartQty());
        System.out.println("Customer 4 " + customer4.getTotalCartQty());
        System.out.println("Customer 3 " + customer3.getTotalCartQty());


    }
}
