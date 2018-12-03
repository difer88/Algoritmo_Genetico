package main.java.com.transportanalysis.test.services.cargo;

import main.java.com.transportanalysis.test.models.Product;

public interface CargoService {

    Product getProductById(long productId) throws Exception;

    Product createNewProduct(double amount, String type);

}
