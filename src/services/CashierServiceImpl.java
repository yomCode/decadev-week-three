package services;

import Interfaces.CashierInterface;
import enums.Role;
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

        if(staff.getRole().equals(Role.CASHIER)){
            if(customerService.buyProduct(store, customer).equals("Product purchased successfully")){
                for(int i =0; i< store.getProductsList().size(); i++){
                    if(store.getProductsList().get(i).getProductName().equals(customer.getProductName().toLowerCase())){
                        sellStatus.append(customer.getTotalCartQty()).append(" units of ").append(customer.getProductName()).append(" sold. \n\n"//;
                        ).append(receipt.printReceipt(store, staff, customer, customerService));

                        store.getProductsList().get(i).setQuantity(store.getProductsList().get(i).getQuantity() - customer.getTotalCartQty());
                    }

                    if (store.getProductsList().get(i).getQuantity() == 0) {
                        store.getProductsList().get(i).setStatus(new StringBuilder("OUT OF STOCK!"));
                    } else {
                        store.getProductsList().get(i).setStatus(new StringBuilder("AVAILABLE"));
                    }

                }

            }else{
                sellStatus.append("Product not sold");
            }

        }else{
            sellStatus.append("Access Denied!");
        }
        return sellStatus.toString();
    }
}
