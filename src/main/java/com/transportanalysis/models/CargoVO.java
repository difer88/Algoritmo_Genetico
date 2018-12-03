package main.java.com.transportanalysis.models;

import java.util.List;

public class CargoVO {

    protected long cargoId;
    protected List<ProductVO> productsList;

    public CargoVO(long cargoId, List<ProductVO> productsList) {
        this.cargoId = cargoId;
        this.productsList = productsList;
    }

    public long getCargoId() {
        return cargoId;
    }

    public void setCargoId(long cargoId) {
        this.cargoId = cargoId;
    }

    public List<ProductVO> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<ProductVO> productsList) {
        this.productsList = productsList;
    }
}
