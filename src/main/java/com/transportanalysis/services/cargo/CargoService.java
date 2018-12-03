package main.java.com.transportanalysis.services.cargo;

import main.java.com.transportanalysis.models.ProductVO;

public interface CargoService {

    ProductVO getProductById(long productId) throws Exception;

    ProductVO createNewProduct(double amount, String type);

}
