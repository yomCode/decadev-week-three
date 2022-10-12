package services;

import Interfaces.CustomerInterface;
import exceptions.ProductIsNotAvaialbleEception;
import models.*;

public class CustomerServiceImpl implements CustomerInterface {
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
    public String buyProduct(Store store, Staff staff){










        throw new ProductIsNotAvaialbleEception("Product is not available");
    }
}
