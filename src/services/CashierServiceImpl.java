package services;

import Interfaces.CashierInterface;
import enums.Role;
import exceptions.AccessDenialException;
import models.Customer;
import models.PrintReceipt;
import models.Staff;
import models.Store;

public class CashierServiceImpl implements CashierInterface {
    @Override
    public String sellProduct(Store store, Staff staff, Customer customer, CustomerServiceImpl customerService){
        //unique Field----------------------------------------------------
        PrintReceipt receipt = new PrintReceipt();

        StringBuilder sellStatus = new StringBuilder();

//        if(staff.getRole().equals(Role.CASHIER)){
//            for(int i = 0; i< store.getCustomerQueue().size(); i++) {
//                for (int j = 0; j < store.getProductsList().size(); j++) {
//                    if (store.getProductsList().get(i).getProductName().equalsIgnoreCase(customer.getPurchaseCart().get(i).getItemName())) {
//                        if (store.getCustomerQueue().element().getCashAvailable() >= customer.getTotalCost()) {
//                            store.getCustomerQueue().poll();
//                            for(int k = 0; k< customer.getPurchaseCart().size(); k++){
//
//                            }
//                        }
//
//                    }
//
//                    if (store.getProductsList().get(i).getQuantity() == 0) {
//                        store.getProductsList().get(i).setStatus(new StringBuilder("OUT OF STOCK!"));
//                    } else {
//                        store.getProductsList().get(i).setStatus(new StringBuilder("AVAILABLE"));
//                    }
//
//                }
//
//            }
//
//        }else{
//            throw new AccessDenialException("Access Denied!");
       // }
        return sellStatus.toString();
    }
}
