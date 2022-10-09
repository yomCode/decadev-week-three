//package Tests;
//
//
//
//import enums.Qualification;
//import enums.Role;
//import enums.Sex;
//import models.*;
//import org.junit.jupiter.api.Test;
//import services.ProductFileReaderService;
//
//import java.io.IOException;
//import java.time.LocalDate;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class PrintReceiptTest {
//    Store newStore = new Store();
//    ProductFileReaderService read =  new ProductFileReaderService();
//
//    PrintReceipt receipt = new PrintReceipt();
//
//
//
//    @Test
//    void productSoldAndReceiptIsPrinted() throws IOException {
//        LocalDate dateTime = LocalDate.now();
//        int slipNumber = 0; //(int) (Math.random() * 1_000_000);
//
//
//        newStore.setProductsList(read.productList());
//        List<Products> availableProduct = newStore.getProductsList();
//
//        Staff staff1 = new Staff ( 323, "Adeola Johnson", 20, Sex.FEMALE, Qualification.BSC, "Adeola123@gmail.com", Role.CASHIER);
//        Customer customer2 = new Customer(1, "monster",  50000.00, 20);
//
//        String prodReceipt = "";
//        for(int i = 0; i<availableProduct.size(); i++) {
//            if (customer2.getProductName().toLowerCase().equals(availableProduct.get(i).getProductName()))
//             prodReceipt =   "RECEIPT \n" + "--------------------- \n" + "Date: " + dateTime + "\nSlip Number: " + slipNumber + "\n\n"
//                        +"Item name: " + availableProduct.get(i).getProductName() + "  Qty: " + customer2.getQty() +
//                        "   Rate: " + availableProduct.get(i).getRatePerUnit() + "     Total: " + (availableProduct.get(i).getRatePerUnit() * customer2.getQty()) +
//                        "\nCashier: " + staff1.getName() + "\n \nGOODS BOUGHT IN GOOD CONDITION ARE NOT RETURNABLE \n"
//                        + "Thanks for your patronage!";
//
//        }
//
//        String expected = prodReceipt;
//
//
//        String actual = receipt.printReceipt(newStore, staff1, customer2);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void productNotSoldAndReceiptNotPrinted() throws IOException {
//
//        Staff staff1 = new Staff ( 323, "Adeola Johnson", 20, Sex.FEMALE, Qualification.BSC, "Adeola123@gmail.com", Role.CASHIER);
//        Customer customer2 = new Customer(1, 5000.00,  "monster", 20);
//
//
//        newStore.setProductsList(read.productList());
//
//        String expected = "No product was purchased";
//        String actual = receipt.printReceipt(newStore, staff1, customer2);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void printReceiptAccessDenied() throws IOException {
//        Staff staff2 = new Staff( 12,"Hakeem Adewale", 45, Sex.MALE, Qualification.MSC, "Adewale@gmail.com", Role.MANAGER);
//        Customer customer2 = new Customer(1, 5000.00,  "monster", 20);
//
//        newStore.setProductsList(read.productList());
//
//        String expected = "Access Denied!";
//        String actual = receipt.printReceipt(newStore, staff2, customer2);
//
//        assertEquals(expected, actual);
//    }
//}
