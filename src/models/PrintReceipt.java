package models;

import Interfaces.PrintReceiptInterface;
import enums.Qualification;
import enums.Role;
import enums.Sex;
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

    public PrintReceipt(Integer id, String name, Integer age, Sex sex, Qualification qualification, String email, Double cashPaid, Double balance, Integer qty, LocalDateTime dateTime, Customer customer, Integer slipNumber, Products product) {
        super(id, name, age, sex, qualification, email, cashPaid, balance, qty);
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
        LocalDate dateTime = LocalDate.now();
        slipNumber = 0; //(int) (Math.random() * 1_000_000);
        List<Products> availableProduct = store.getProductsList();

        if(staff.getRole().equals(Role.CASHIER)){

                if(customer.buyProduct(store).equals("Product purchased successfully")){
                    for(int i = 0; i<availableProduct.size(); i++) {
                        if (customer.getProductName().toLowerCase().equals(availableProduct.get(i).getProductName()))
                            return "RECEIPT \n" + "--------------------- \n" + "Date: " + dateTime + "\nSlip Number: " + slipNumber + "\n\n"
                                    + "Item name: " + availableProduct.get(i).getProductName() + "  Qty: " + customer.getTotalCartQty() +
                                    "   Rate: " + availableProduct.get(i).getRatePerUnit() + "     Total: " + (availableProduct.get(i).getRatePerUnit() * customer.getTotalCartQty()) +
                                    "\nCashier: " + staff.getName() + "\n \nGOODS BOUGHT IN GOOD CONDITION ARE NOT RETURNABLE \n"
                                    + "Thanks for your patronage!";

                    }

                }else{
                    return "No product was purchased";
                }


        }
            return "Access Denied!";

    }

}
