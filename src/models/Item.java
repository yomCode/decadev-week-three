package models;

import services.ProductFileReaderService;

import java.io.IOException;
import java.util.List;

public class Item extends Store{

    private String itemName;
    private Integer itemQty;
    private Double price;
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

    public Double getPrice() {
        ProductFileReaderService read = new ProductFileReaderService();
        try {
            super.setProductsList(read.productList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        price = 0.0;
        List<Products> list = super.getProductsList();
        for(int i = 0; i< list.size(); i++){
            if(super.getProductsList().get(i).getProductName().equalsIgnoreCase(getItemName())) price = itemQty * list.get(i).getRatePerUnit();

        }

        return price;
    }

    @Override
    public String toString() {

        return "ItemName: " + itemName +
                "  ItemQty: " + itemQty +
                "  Price: " + getPrice();
    }


}
