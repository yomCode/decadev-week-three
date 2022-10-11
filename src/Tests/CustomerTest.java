//package Tests;
//
//import models.Customer;
//import models.ProductFileReaderService;
//import models.Store;
//import org.junit.jupiter.api.Test;
//import java.io.IOException;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class CustomerTest {
//
//    models.ProductFileReaderService read = new models.ProductFileReaderService();
//
//    Store newStore = new Store();
//
//
//
//
//
//
//
//
//    @Test
//    void productIsPurchased() throws IOException {
//        Customer customer1 = new Customer(1, 50000.00,  "monster", 20);
//
//        newStore.setProductsList(read.productList());
//
//        String expected = "Product purchased successfully";
//        String actual = customer1.buyProduct(newStore);
//
//        assertEquals(expected, actual);
//    }
//
//
//    @Test
//    void productIsNotPurchasedBasedOnCash() throws IOException {
//        Customer customer1 = new Customer(1, 5000.00,  "monster", 20);
//
//        newStore.setProductsList(read.productList());
//
//        String expected = "Insufficient balance to complete purchase";
//        String actual = customer1.buyProduct(newStore);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void productIsNotPurchasedBasedOnInsufficientQuantityAvailable() throws IOException {
//        Customer customer1 = new Customer(1, 50000.00,  "monster", 60);
//
//        newStore.setProductsList(read.productList());
//
//        String expected = "Enter a lower quantity";
//        String actual = customer1.buyProduct(newStore);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void productIsNotPurchasedBasedOnAvailabilityStatus() throws IOException {
//        Customer customer1 = new Customer(1, 50000.00,  "brush", 20);
//
//        newStore.setProductsList(read.productList());
//
//        String expected = "Product is not available";
//        String actual = customer1.buyProduct(newStore);
//
//        assertEquals(expected, actual);
//    }
//
//
//
//
//}
