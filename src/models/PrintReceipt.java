package models;

import Interfaces.PrintReceiptInterface;
import enums.Qualification;
import enums.Role;
import enums.Sex;
import services.CustomerServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class PrintReceipt extends Customer implements PrintReceiptInterface{

    //FIELDS-------------------------------------------------------------------------->
    private  LocalDateTime dateTime;
    private Customer customer;
    private Integer slipNumber;
    private Products product;

    public PrintReceipt(){


    }

    public PrintReceipt(LocalDateTime dateTime, Customer customer, Integer slipNumber) {
        this.dateTime = dateTime;
        this.customer = customer;
        this.slipNumber = slipNumber;
    }

    public PrintReceipt(LocalDateTime dateTime, Customer customer, Integer slipNumber, Products product) {
        this.dateTime = dateTime;
        this.customer = customer;
        this.slipNumber = slipNumber;
        this.product = product;
    }

    public PrintReceipt(Double cashPaid, Integer qty, LocalDateTime dateTime, Customer customer, Integer slipNumber, Products product) {
        super(cashPaid, qty);
        this.dateTime = dateTime;
        this.customer = customer;
        this.slipNumber = slipNumber;
        this.product = product;
    }

    public PrintReceipt(Integer id, String name, Integer age, Sex sex, Qualification qualification, String email, Double cashAvailable, Integer qty, LocalDateTime dateTime, Customer customer, Integer slipNumber, Products product) {
        super(id, name, age, sex, qualification, email, cashAvailable, qty);
        this.dateTime = dateTime;
        this.customer = customer;
        this.slipNumber = slipNumber;
        this.product = product;
    }

    public PrintReceipt(Integer id, Double cashPaid, Integer qty, LocalDateTime dateTime, Customer customer, Integer slipNumber, Products product) {
        super(id, cashPaid, qty);
        this.dateTime = dateTime;
        this.customer = customer;
        this.slipNumber = slipNumber;
        this.product = product;
    }

    public PrintReceipt(int id, double cashPaid, String productName, int qty, LocalDateTime dateTime, Customer customer, Integer slipNumber, Products product) {
        super(id, cashPaid, productName, qty);
        this.dateTime = dateTime;
        this.customer = customer;
        this.slipNumber = slipNumber;
        this.product = product;
    }



    public PrintReceipt(int id, double cashPaid, String productName, int qty, LocalDateTime dateTime, Customer customer, Integer slipNumber) {
        super(id, cashPaid, productName, qty);
        this.dateTime = dateTime;
        this.customer = customer;
        this.slipNumber = slipNumber;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getSlipNumber() {
        return slipNumber;
    }

    public void setSlipNumber(Integer slipNumber) {
        this.slipNumber = slipNumber;
    }

    @Override
    public String toString() {
        return "PrintReceipt{" +
                "dateTime=" + dateTime +
                ", customer=" + customer +
                ", slipNumber=" + slipNumber +
                ", product=" + product +
                '}';
    }

    @Override
    public  String printReceipt(Store store, Staff staff, Customer customer){
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        LocalDate dateTime = LocalDate.now();
        slipNumber = 0; //(int) (Math.random() * 1_000_000);

        if(staff.getRole().equals(Role.CASHIER)){

            ProductFileReaderService reader = new ProductFileReaderService();
            reader.productList();
                    String items = "";

                        for(int i = 0; i< store.getCustomerQueue().element().getPurchaseCart().size(); i++) {
                            String itemName = store.getCustomerQueue().element().getPurchaseCart().get(i).getItemName();
                            Integer itemQty = store.getCustomerQueue().element().getPurchaseCart().get(i).getItemQty();
                            Double itemPrice = store.getCustomerQueue().element().getPurchaseCart().get(i).getPrice();
                            items += "Item: " + itemName + "   itemQty: " + itemQty + "   Price: " + itemPrice + "\n";
                        }


                    return "RECEIPT \n" + "--------------------- \n" + "Date: " + dateTime + "\nSlip Number: " + slipNumber + "\n\n"
                                    + items + "\n    Total: " + store.getCustomerQueue().element().getTotalCost() +
                                    "\nCashier: " + staff.getName() + "\n \nGOODS BOUGHT IN GOOD CONDITION ARE NOT RETURNABLE \n"
                                    + "Thanks for your patronage!\n\n";


        }
            return "Access Denied!";

    }

}
