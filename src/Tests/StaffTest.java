//package Tests;
//
//import enums.Qualification;
//import enums.Role;
//import enums.Sex;
//import models.*;
//import org.junit.jupiter.api.Test;
//import models.ProductFileReaderService;
//
//import java.io.IOException;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class StaffTest {
//
//    //Staff instances--------------------------------------------------------------------------------------------------------------->
//    Staff staff1 = new Staff( 12,"Hakeem Adewale", 45, Sex.MALE, Qualification.MSC, "Adewale@gmail.com", Role.MANAGER);
//    Staff staff2 = new Staff ( 323, "Adeola Johnson", 20, Sex.FEMALE, Qualification.BSC, "Adeola123@gmail.com", Role.CASHIER);
//
//    //Applicant instances--------------------------------------------------------------------------------------------------------------->
//    Applicant applicant1 = new Applicant(2332, "Ronke George", 26, Sex.FEMALE, Qualification.HND,
//            "rony123@gmail.com", 86.0, 3);
//    Applicant applicant2 = new Applicant(2322, "John Banks", 25, Sex.MALE, Qualification.BSC,
//            "john123@gmail.com", 83.5, 3);
//
//    //Products instances--------------------------------------------------------------------------------------------------------------->
//    Store newStore = new Store();
//
//    models.ProductFileReaderService read = new models.ProductFileReaderService();
//
//
//
//    PrintReceipt receipt = new PrintReceipt();
//
//
//    //Manager Method Tests--------------------------------------------------------------------------------------------------------------->
//    @Test
//    void cashierIsHired(){
//        String expected = "You are hired!";
//        String actual = staff1.hireCashier(staff1, applicant1);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void cashierIsNotHiredBasedOnExam(){
//        String expected = "Sorry, you are not qualified for this position.";
//        String actual = staff1.hireCashier(staff1, applicant2);
//
//        assertEquals(expected, actual);
//    }
//
////    @Test
////    void cashiertHireAccessDenied(){
////        String expected =  throw new AccessDenialException("Access Denied!");
////        String actual = staff1.hireCashier(staff2, applicant1);
////
////        assertEquals(expected, actual);
////    }
//
//
//    //Cashier Method Tests--------------------------------------------------------------------------------------------------------------->
//    @Test
//    void sellProductSuccessful() throws IOException {
//        Customer customer1 = new Customer(1, 200000.00,  "tissue paper", 100);
//
//        newStore.setProductsList(read.productList());
//
//        String expected = customer1.getQty() + " units of " + customer1.getProductName() + " sold. \n\n"//;
//                + receipt.printReceipt(newStore, staff2, customer1);
//
//        String actual = staff2.sellProduct(newStore, staff2, customer1);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void sellProductNotSuccessful() throws IOException {
//        Customer customer2 = new Customer(1, 2000.00,  "monster", 20);
//
//        newStore.setProductsList(read.productList());
//
//        String expected = "Product not sold";
//        String actual = staff1.sellProduct(newStore, staff2, customer2);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void sellProductAccessDenied() throws IOException {
//        Customer customer2 = new Customer(1, 50000.00,  "monster", 20);
//
//        newStore.setProductsList(read.productList());
//
//        String expected = "Access Denied!";
//        String actual = staff1.sellProduct(newStore, staff1, customer2);
//
//        assertEquals(expected, actual);
//    }
//
//
//
//}