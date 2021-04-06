package test;

import javax.validation.constraints.*;

public class Data {
    @NotNull
    @Size(min=4, message="sku should have atleast 4 characters")
    @Pattern(regexp="^Nyk.*", message = "sku name must start with Nyk")
    private String sku;
    @NotNull(message = "Price must not be null")
    private double price;
    @NotNull
    @Size(min=5, message="storeCode should have atleast 5 characters")
    @Pattern(regexp="^Nyk.*", message = "sku name must start with Nyk")
    private String storeCode;

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public void setSku(String sku){
        this.sku = sku;
    }
    public String getSku(){
        return this.sku;
    }
    public double getPrice(){
        return this.price;
    }

}
