package models;

import enums.Qualification;
import enums.Sex;
import java.util.*;

public class Customer extends Person{

    //FIELDS------------------------------------------------------------------>
    private String productName;
    private Integer customerId;
    private Double cashAvailable;
    private Integer totalCartQty;
    private Double totalCost;
    private List<Item> purchaseCart;



    //CONSTRUCTORS------------------------------------------------------------------>

    public Customer(){

    }

    public Customer(Double cashPaid, Integer qty) {
        this.cashAvailable = cashPaid;

        this.totalCartQty = qty;

    }

    public Customer(String productName, Double cashAvailable, Integer qty, ArrayList<Item> productCart) {
        this.productName = productName;
        this.cashAvailable = cashAvailable;
        this.totalCartQty = qty;
        this.purchaseCart = productCart;
    }

    public Customer(Integer customerId, ArrayList<Item> productCart, Double cashAvailable) {
        this.customerId = customerId;
        this.purchaseCart = productCart;
        this.cashAvailable = cashAvailable;
    }

    public Customer(Integer id, Double cashAvailable){
        this.customerId = id;
        this.cashAvailable = cashAvailable;
    }

    public Customer(Integer id, String productName, Double cashAvailable, Integer qty, ArrayList<Item> productCart) {
        super(id);
        this.productName = productName;
        this.cashAvailable = cashAvailable;
        this.totalCartQty = qty;
        this.purchaseCart = productCart;
    }

    public Customer(Integer id, String name, Integer age, Sex sex, Qualification qualification, String email, Double cashAvailable, Integer qty) {
        super(id, name, age, sex, qualification, email);
        this.cashAvailable = cashAvailable;
        this.totalCartQty = qty;
    }

    public Customer(Integer id, Double cashAvailable, Integer qty) {
        super(id);
        this.cashAvailable = cashAvailable;
        this.totalCartQty = qty;
    }

    public Customer(int id, double cashAvailable, String productName, int qty) {
        super(id);
        this.cashAvailable = cashAvailable;
        this.productName = productName;
        this.totalCartQty = qty;
    }

    //GETTERS & SETTERS------------------------------------------------------------------>


    public Double getCashAvailable() {
        return cashAvailable;
    }


    public Integer getTotalCartQty() {
        totalCartQty = 0;
        for(int i = 0; i< purchaseCart.size(); i++){
           totalCartQty += purchaseCart.get(i).getItemQty();
        }

        return totalCartQty;
    }

    public String getProductName() {
        return productName;
    }


    public Double getTotalCost() {
        totalCost = 0.0;
        for(int i = 0; i< this.getPurchaseCart().size(); i++){
            totalCost += getPurchaseCart().get(i).getPrice();
        }
        return totalCost;
    }

    public List<Item> getPurchaseCart() {
        return purchaseCart;
    }

    public void setPurchaseCart(List<Item> purchaseCart) {
        this.purchaseCart = purchaseCart;
    }

    @Override
    public String toString() {
        return "CustomerId: " + customerId +
                " cashPaid: " + cashAvailable +
                "  Shopping Cart" + purchaseCart;
    }




}
