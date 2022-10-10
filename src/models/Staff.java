package models;

import Interfaces.CashierInterface;
import Interfaces.ManagerInterface;
import enums.Qualification;
import enums.Role;
import enums.Sex;
import exceptions.AccessDenialException;

public class Staff extends Person implements ManagerInterface, CashierInterface {

    private Role role;


    //CONSTRUCTOR----------------------------

    //No Args
    public  Staff(){

    }

    //All Args

    public Staff(Role role) {
        this.role = role;
    }

    public Staff(Integer id, String name, Integer age, Sex sex, Qualification qualification, String email, Role role) {
        super(id, name, age, sex, qualification, email);
        this.role = role;
    }

    public Staff(Integer id, String name, Integer age, Sex sex, Qualification qualification, String email) {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "Staff{" +
                "role=" + role +
                '}';
    }


    @Override
    public String hireCashier(Staff staff, Applicant applicant){

        if(staff.getRole().equals(Role.MANAGER)){
            if((applicant.getAge() >= 23 && applicant.getAge()<= 30)
                    && applicant.getSex().equals(Sex.FEMALE)
                    && (applicant.getQualification().equals(Qualification.BSC)
                    || applicant.getQualification().equals(Qualification.HND))
                    && applicant.takeExam().equals("Passed")){
                return "You are hired!";
            }else{

                return "Sorry, you are not qualified for this position.";
            }

        }else{
            throw new AccessDenialException("Access Denied");
        }

    }



    @Override
    public String sellProduct(Store store, Staff staff, Customer customer){
        //unique Field----------------------------------------------------
        PrintReceipt receipt = new PrintReceipt();

        StringBuilder sellStatus = new StringBuilder();

        if(staff.getRole().equals(Role.CASHIER)){
            if(customer.buyProduct(store).equals("Product purchased successfully")){
                for(int i =0; i< store.getProductsList().size(); i++){
                   if(store.getProductsList().get(i).getProductName().equals(customer.getProductName().toLowerCase())){
                       sellStatus.append(customer.getTotalCartQty()).append(" units of ").append(customer.getProductName()).append(" sold. \n\n"//;
                       ).append(receipt.printReceipt(store, staff, customer));

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
