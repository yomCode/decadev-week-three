package models;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Store {
    //FIELDS------------------------------------------------------------------>
    private Integer id;
    private String storeName;
    private List<Staff> staffList;
    private List<Products> productsList;
    private PriorityQueue<Customer> customerQueue;
    private LinkedList<Customer> customerQueue2;
    private Customer customer;


    //CONSTRUCTORS------------------------------------------------------------------>
    public Store(){

    }

    public Store(Integer id, String name){
        this.id = id;
        this.storeName = name;
    }

    public Store(Integer id, String name, List<Staff> staffList, List<Products> productsList) {
        this.id = id;
        this.storeName = name;
        this.staffList = staffList;
        this.productsList = productsList;
    }


    //SETTERS & GETTERS------------------------------------------------------------------>
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }

    public PriorityQueue<Customer> getCustomerQueue() {
        return this.customerQueue;
    }

    public void setCustomerQueue(PriorityQueue<Customer> customerQueue) {
        this.customerQueue = customerQueue;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LinkedList<Customer> getCustomerQueue2() {
        return customerQueue2;
    }

    public void setCustomerQueue2(LinkedList<Customer> customerQueue2) {
        this.customerQueue2 = customerQueue2;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + storeName + '\'' +
                ", staffList=" + staffList +
                " productsList=" + productsList;
    }


}
