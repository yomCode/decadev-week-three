package services;

import Interfaces.CashierInterface;
import enums.Role;
import exceptions.AccessDenialException;
import models.*;

import java.util.PriorityQueue;
import java.util.Queue;

public class CashierServiceImpl implements CashierInterface {
    @Override
    public String sellProduct(Store store, Staff staff, Queue<Customer> customerQueue){
        //unique Field----------------------------------------------------
        PrintReceipt receipt = new PrintReceipt();

        String sellStatus = "";

        if(staff.getRole().equals(Role.CASHIER)){
            if(customerQueue instanceof PriorityQueue<Customer>){
                if (store.getCustomerQueue().element().getCashAvailable() >= store.getCustomerQueue().element().getTotalCost()) {
                    Customer eachCustomer = store.getCustomerQueue().element();
                    eachCustomer.setCashAvailable(eachCustomer.getCashAvailable() - eachCustomer.getTotalCost());
                    sellStatus += "Product sold to customer: " + eachCustomer.getCustomerId() +  "\n\n"
                            + receipt.printReceipt(store, staff, store.getCustomer());
                    store.getCustomerQueue().remove();

                }else{
                    for (int i = 0; i< store.getProductsList().size(); i++){
                        for (int j = 0; j< store.getCustomerQueue().element().getPurchaseCart().size(); j++){
                            //Add back the items not purchased back to the store list of products---------------------------------------------------
                            Customer eachCustomer = store.getCustomerQueue().element();
                            if (store.getProductsList().get(i).getProductName().equalsIgnoreCase(eachCustomer
                                    .getPurchaseCart().get(j).getItemName())){

                                store.getProductsList().get(i).setQuantity(store.getProductsList().get(i).getQuantity() +
                                        eachCustomer.getPurchaseCart().get(j).getItemQty());
                            }
                        }

                    }
                    sellStatus += "Insufficient balance to sell to Customer: " + store.getCustomerQueue().element().getCustomerId();
                    store.getCustomerQueue().remove();
                }
            }else{
                for(int i = 0; i< store.getCustomerQueue2().size(); i++){
                    Customer eachCustomer = store.getCustomerQueue2().get(i);
                    if (eachCustomer.getCashAvailable() >= eachCustomer.getTotalCost()) {
                        eachCustomer.setCashAvailable(eachCustomer.getCashAvailable() - eachCustomer.getTotalCost());

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
            }
            return sellStatus;

        }else{
            throw new AccessDenialException("Access Denied!");
        }

    }


}
