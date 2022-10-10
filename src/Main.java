
import enums.Qualification;
import enums.Role;
import enums.Sex;
import models.*;
import services.CashierServiceImpl;
import services.CustomerServiceImpl;
import services.ManagerServiceImpl;
import services.ProductFileReaderService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
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


        Customer customer1 = new Customer(2,cartProduct, 15000.0);
        Customer customer2 = new Customer(1, cartProduct1, 5000.0);
        Customer customer3 = new Customer(3, cartProduct2, 20000.0);


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
        Item item5 = new Item("milk", 35);
        Item item6 = new Item("spoon", 15);
        Item item7 = new Item("knife", 2);
        Item item8 = new Item("sugar", 30);

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

//        System.out.println(customer1.getPurchaseCart());


        //Setting the Array values to customers Cart-----------------------------------------------------------------------------------
        customer1.setPurchaseCart(cartProduct);
        customer2.setPurchaseCart(cartProduct1);
        customer3.setPurchaseCart(cartProduct2);

        //Adding the customers to Priority Queue which is a field in the Store entity (Position in the queue is determined by the number of total quantity)---
        PriorityQueue<Customer> customerQueue = new PriorityQueue<>(Comparator.comparing(Customer::getTotalCartQty));

        customerQueue.add(customer1);
        customerQueue.add(customer2);
        customerQueue.add(customer3);

        store1.setCustomerQueue(customerQueue);

        //Printing out the queue in order------------------------------------------------------------------------------------------------
        for(Customer customerOnQueue: store1.getCustomerQueue()){
            System.out.println(customerOnQueue);
        }

//        cashier.sellProduct(store1, staff3, customer1, customerService);
//        cashier.sellProduct(store1, staff3, customer2, customerService);

//        for(Customer queue: store1.getCustomerQueue()){
//            System.out.println(queue);
//        }

//        System.out.println(customer1.getTotalCost());



//        System.out.println(customer2.buyProduct(store1));
//        System.out.println(staff2.sellProduct(store1, staff2, customer2) + "\n");
//        System.out.println(customer2.buyProduct(store1));


    }
}
