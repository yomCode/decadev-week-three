package models;

public class Item {

    private String itemName;
    private Integer itemQty;
    private Double price;
    private Double totalCost;
    private Products products;

    public Item(String itemName, Integer itemQty) {
        this.itemName = itemName;
        this.itemQty = itemQty;
    }



    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemQty() {
        return itemQty;
    }

    public void setItemQty(Integer itemQty) {
        this.itemQty = itemQty;
    }

    public Double getTotalCost() {
        totalCost = products.getRatePerUnit() * this.getItemQty();

        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemQty=" + itemQty +
                ", totalCost=" + totalCost +
                '}';
    }


}
