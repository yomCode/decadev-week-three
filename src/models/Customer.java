package models;

import Interfaces.*;
import enums.Qualification;
import enums.Sex;
import java.util.*;

public class Customer extends Person {

    //FIELDS------------------------------------------------------------------>
    private String productName;
    private Integer customerId;
    private Double cashAvailable;
    private Integer totalCartQty;
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

    public void setCashAvailable(Double cashAvailable) {
        this.cashAvailable = cashAvailable;
    }

    public Integer getTotalCartQty() {
        totalCartQty = 0;
        for(int i = 0; i< purchaseCart.size(); i++){
           totalCartQty += purchaseCart.get(i).getItemQty();
        }

        return totalCartQty;
    }

    public void setTotalCartQty(Integer totalCartQty) {
        this.totalCartQty = totalCartQty;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<Item> getPurchaseCart() {
        return purchaseCart;
    }

    public void setPurchaseCart(ArrayList<Item> purchaseCart) {
        this.purchaseCart = purchaseCart;
    }


    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "CustomerId: " + customerId +
                " cashPaid: " + cashAvailable +
                "  Shopping Cart" + purchaseCart;
    }




}
