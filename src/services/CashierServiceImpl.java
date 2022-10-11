package services;

import Interfaces.CashierInterface;
import enums.Role;
import exceptions.AccessDenialException;
import models.*;

public class CashierServiceImpl implements CashierInterface {
    @Override
    public String sellProduct(Store store, Staff staff){
        //unique Field----------------------------------------------------
        PrintReceipt receipt = new PrintReceipt();

        String sellStatus = "";

        if(staff.getRole().equals(Role.CASHIER)){
            while(store.getCustomerQueue().iterator().hasNext()) {
                if (store.getCustomerQueue().element().getCashAvailable() >= store.getCustomerQueue().element().getTotalCost()) {
                    store.getCustomerQueue().remove();

                    sellStatus += "Product sold to customer\n\n";

                }else{
                    for (int i = 0; i< store.getProductsList().size(); i++){
                        for (int j = 0; j< store.getCustomerQueue().element().getPurchaseCart().size(); j++){
                            if (store.getProductsList().get(i).getProductName().equalsIgnoreCase(store.getCustomerQueue().element()
                            .getPurchaseCart().get(j).getItemName())){
                                store.getProductsList().get(i).setQuantity(store.getProductsList().get(i).getQuantity() +
                                store.getCustomerQueue().element().getPurchaseCart().get(j).getItemQty());
                            }
                        }

                    }
                    store.getCustomerQueue().remove();
                }
            }

        }else{
            throw new AccessDenialException("Access Denied!");
        }
        return sellStatus;
    }
}
