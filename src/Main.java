
import enums.Qualification;
import enums.Role;
import enums.Sex;
import models.*;
import services.ProductFileReaderService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;


public class Main {
    public static void main(String[] args) throws IOException {

        //Instances of a staff Class------------------------------------------------------------------------------------------->
        Staff staff1 = new Staff( 12,"Hakeem Adewale", 45, Sex.MALE, Qualification.MSC, "Adewale@gmail.com", Role.MANAGER);
        Staff staff2 = new Staff ( 323, "Adeola Johnson", 20, Sex.FEMALE, Qualification.BSC, "Adeola123@gmail.com", Role.CASHIER);
        Staff staff3 = new Staff(324, "Alex Austin",23, Sex.MALE, Qualification.HND, "alex123@gmail.com", Role.CASHIER);

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

        Customer customer1 = new Customer(2,cartProduct, 10000.00);
        Customer customer2 = new Customer(1, cartProduct1, 50000.0);




        cartProduct.add(new Item("milo", 20));
        cartProduct.add(new Item("monster", 5));
        cartProduct.add(new Item("orijin", 2));
        cartProduct.add(new Item("tissue paper", 20));



        cartProduct1.add(new Item("battery", 30));
        cartProduct1.add(new Item("spoon", 15));
        cartProduct1.add(new Item("knife", 2));
        cartProduct1.add(new Item("sugar", 5));
        System.out.println(customer1.getProductCart());


//        customer1.setProductCart(cartProduct);
//        customer2.setProductCart(cartProduct1);


//        customerQueue.add(customer1.getProductCart());
//        customerQueue.add(customer2.getProductCart());

//


        customer1.setProductCart(cartProduct);
        customer2.setProductCart(cartProduct1);

        PriorityQueue<Customer> customerQueue = new PriorityQueue<>((c1, c2) -> c1.getQty().compareTo(c2.getQty()));

        customerQueue.add(customer1);
        customerQueue.add(customer2);

        store1.setCustomerQueue(customerQueue);

//        System.out.println(customer1.getProductCart());
//        System.out.println(customer2.getProductCart());

//        System.out.println(customerQueue);
        System.out.println(store1.getCustomerQueue());
//        System.out.println(customer1.getQty());

//        for(Object item : customer1.getProductCart()){
//            System.out.println();
//        }
//
//        for(Object item : customer2.getProductCart()){
//            System.out.println("Product name: " + item);
//        }

//        System.out.println(customer2.buyProduct(store1));
//        System.out.println(staff2.sellProduct(store1, staff2, customer2) + "\n");
//        System.out.println(customer2.buyProduct(store1));


    }
}
