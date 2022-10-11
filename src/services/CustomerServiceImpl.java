package services;

import Interfaces.CustomerInterface;
import exceptions.ProductIsNotAvaialbleEception;
import models.Customer;
import models.Item;
import models.Products;
import models.Store;

import java.util.List;

public class CustomerServiceImpl implements CustomerInterface {

//    public Double toCartCost(){
//
//
//    }

    @Override
    public Products addToCart(Store store, Item item, Customer customer){
        //Loop through the Product list to search for available products using the name ot the product--------------------------------
        for(int i = 0; i< store.getProductsList().size(); i++){
            Products eachProduct = store.getProductsList().get(i);
            //checking if any product has the same name as the item name entered by the customer,
            // and also if the product has enough quantity to meet customer's need------------------------>
            if(eachProduct.getProductName().equalsIgnoreCase(item.getItemName())
                    && eachProduct.getQuantity() >= item.getItemQty()) {
                //If product exist and there is enough quantity, then add to the customer cart-------------------------
                customer.getPurchaseCart().add(item);
                //After adding, the quantity of such product should be updated to ensure,
                // the next customer does select out of stock product----------------------------------------------------
                eachProduct.setQuantity(eachProduct.getQuantity() - item.getItemQty());

            }
        }

        return null;
    }


    //buyProduct METHOD OF CASHIER------------------------------------------------------------------------------------------->
    @Override
    public String buyProduct(Store store, Customer customer){
        List<Products> availableProducts = store.getProductsList();

        for(int i = 0; i< availableProducts.size(); i++){
            //Check if product is available on the available product list------------------------------
            if(availableProducts.get(i).getProductName().equalsIgnoreCase(customer.getProductName())){
                //Check if selected product is in stock------------------------------------------------------------------
                if(availableProducts.get(i).getQuantity() <= 0) return "OUT OF STOCK!";
                //Check if there is enough quantity to serve the customer's need-----------------------------------------
                if(availableProducts.get(i).getQuantity() > 0 && availableProducts.get(i).getQuantity() >= customer.getTotalCartQty()){
                    //Check if customer have enough cash to pay for the product-------------------------------------------
                    if((availableProducts.get(i).getRatePerUnit()* customer.getTotalCartQty()) <= customer.getCashAvailable()){

                        return "Product purchased successfully";

                    }else{
                        return "Insufficient balance to complete purchase";
                    }

                }else{
                    return "Enter a lower quantity";
                }
            }

        }
        throw new ProductIsNotAvaialbleEception("Product is not available");
    }
}
