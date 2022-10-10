package models;

import Interfaces.*;
import enums.Qualification;
import enums.Sex;
import java.util.*;

public class Customer extends Person implements CustomerInterface {

    //FIELDS------------------------------------------------------------------>
    private String productName;
    private Integer customerId;
    private Double cashPaid;
    private Integer totalCartQty;
    private List<Item> purchaseCart;



    //CONSTRUCTORS------------------------------------------------------------------>

    public Customer(){

    }

    public Customer(Double cashPaid, Integer qty) {
        this.cashPaid = cashPaid;

        this.totalCartQty = qty;

    }

    public Customer(String productName, Double cashPaid, Integer qty, ArrayList<Item> productCart) {
        this.productName = productName;
        this.cashPaid = cashPaid;
        this.totalCartQty = qty;
        this.purchaseCart = productCart;
    }

    public Customer(Integer customerId, ArrayList<Item> productCart, Double cashPaid) {
        this.customerId = customerId;
        this.purchaseCart = productCart;
        this.cashPaid = cashPaid;
    }

    public Customer(Integer id, String productName, Double cashPaid, Integer qty, ArrayList<Item> productCart) {
        super(id);
        this.productName = productName;
        this.cashPaid = cashPaid;
        this.totalCartQty = qty;
        this.purchaseCart = productCart;
    }

    public Customer(Integer id, String name, Integer age, Sex sex, Qualification qualification, String email, Double cashPaid, Double balance, Integer qty) {
        super(id, name, age, sex, qualification, email);
        this.cashPaid = cashPaid;
        this.totalCartQty = qty;
    }

    public Customer(Integer id, Double cashPaid, Integer qty) {
        super(id);
        this.cashPaid = cashPaid;
        this.totalCartQty = qty;
    }

    public Customer(int id, double cashPaid, String productName, int qty) {
        super(id);
        this.cashPaid = cashPaid;
        this.productName = productName;
        this.totalCartQty = qty;
    }

    //GETTERS & SETTERS------------------------------------------------------------------>


    public Double getCashPaid() {
        return cashPaid;
    }

    public void setCashPaid(Double cashPaid) {
        this.cashPaid = cashPaid;
    }

    public Integer getTotalCartQty() {
        Integer totalQty = 0;
        for(int i = 0; i< purchaseCart.size(); i++){
           totalQty += purchaseCart.get(i).getItemQty();
        }

        return totalQty;
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
        return "Customer Id: " + customerId +
                " cashPaid: " + cashPaid +
                "  Shopping Cart" + purchaseCart;
    }



    //buyProduct METHOD OF CASHIER------------------------------------------------------------------>
    @Override
    public String buyProduct(Store store){
        List<Products> availableProducts = store.getProductsList();

        for(int i = 0; i< availableProducts.size(); i++){
            //Check if product is available on the available product list------------------------------
            if(availableProducts.get(i).getProductName().equalsIgnoreCase(this.getProductName())){
                //Check if selected product is in stock------------------------------------------------------------------
                if(availableProducts.get(i).getQuantity() <= 0) return "OUT OF STOCK!";
                //Check if there is enough quantity to serve the customer's need-----------------------------------------
                if(availableProducts.get(i).getQuantity() > 0 && availableProducts.get(i).getQuantity() >= this.getTotalCartQty()){
                    //Check if customer have enough cash to pay for the product-------------------------------------------
                        if((availableProducts.get(i).getRatePerUnit()* this.getTotalCartQty()) <= getCashPaid()){

                            return "Product purchased successfully";

                        }else{
                            return "Insufficient balance to complete purchase";
                        }

                    }else{
                        return "Enter a lower quantity";
                    }
            }

        }
        return "Product is not available";
    }


}
