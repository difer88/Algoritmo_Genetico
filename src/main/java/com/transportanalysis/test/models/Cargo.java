package main.java.com.transportanalysis.test.models;

import java.util.List;

public class Cargo {

    protected long cargoId;
    protected List<Product> productsList;

    public Cargo(long cargoId, List<Product> productsList) {
        this.cargoId = cargoId;
        this.productsList = productsList;
    }

    public long getCargoId() {
        return cargoId;
    }

    public void setCargoId(long cargoId) {
        this.cargoId = cargoId;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }
}
