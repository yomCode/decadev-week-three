package services;

import Interfaces.CashierInterface;
import enums.Role;
import exceptions.AccessDenialException;
import models.*;

public class CashierServiceImpl implements CashierInterface {
    @Override
    public String sellProductBasedOnQuantity(Store store, Staff staff){
        //unique Field----------------------------------------------------
        PrintReceipt receipt = new PrintReceipt();

        String sellStatus = "";

        if(staff.getRole().equals(Role.CASHIER)){
                if (store.getCustomerQueue().element().getCashAvailable() >= store.getCustomerQueue().element().getTotalCost()) {

                    sellStatus += "Product sold to customer: " + store.getCustomerQueue().element().getCustomerId() +  "\n\n" + receipt.printReceipt(store, staff, store.getCustomer());
                    store.getCustomerQueue().remove();

                }else{
                    for (int i = 0; i< store.getProductsList().size(); i++){
                        for (int j = 0; j< store.getCustomerQueue().element().getPurchaseCart().size(); j++){
                            //Add back the items not purchased back to the store list of products---------------------------------------------------
                            if (store.getProductsList().get(i).getProductName().equalsIgnoreCase(store.getCustomerQueue().element()
                                .getPurchaseCart().get(j).getItemName())){

                                store.getProductsList().get(i).setQuantity(store.getProductsList().get(i).getQuantity() +
                                store.getCustomerQueue().element().getPurchaseCart().get(j).getItemQty());
                            }
                        }

                    }
                    sellStatus += "Insufficient balance to sell to Customer: " + store.getCustomerQueue().element().getCustomerId();
                    store.getCustomerQueue().remove();
                }

        }else{
            throw new AccessDenialException("Access Denied!");
        }
        return sellStatus;
    }

    public String sellProductFIFO(Store store, Staff staff){
        //unique Field----------------------------------------------------
        PrintReceipt receipt = new PrintReceipt();

        String sellStatus = "";

        if(staff.getRole().equals(Role.CASHIER)){
            for(int i = 0; i< store.getCustomerQueue2().size(); i++){
                Customer eachCustomer = store.getCustomerQueue2().get(i);
                if (eachCustomer.getCashAvailable() >= eachCustomer.getTotalCost()) {

                    sellStatus += "Product sold to customer: " + eachCustomer.getCustomerId();
                    store.getCustomerQueue2().remove();


                }else{
                    for (int j = 0; j< store.getProductsList().size(); j++){
                        for (int k = 0; k< eachCustomer.getPurchaseCart().size(); k++){
                            //Add back the items not purchased back to the store list of products---------------------------------------------------
                            if (store.getProductsList().get(j).getProductName().equalsIgnoreCase(eachCustomer
                                    .getPurchaseCart().get(k).getItemName())){

                                store.getProductsList().get(j).setQuantity(store.getProductsList().get(j).getQuantity() +
                                        eachCustomer.getPurchaseCart().get(k).getItemQty());
                            }
                        }

                    }
                    sellStatus += "Insufficient balance to sell to Customer: " + eachCustomer.getCustomerId();
                    store.getCustomerQueue2().remove();
                }
                break;
            }


        }else{
            throw new AccessDenialException("Access Denied!");
        }
        return sellStatus;
    }
}
