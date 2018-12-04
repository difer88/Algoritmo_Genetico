package main.java.com.transportanalysis.controller;

import main.java.com.transportanalysis.models.ProductVO;
import main.java.com.transportanalysis.services.cargo.CargoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

@RestController
@RequestMapping(path = "/transportanalysis")
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected CargoService cargoService;

    @GetMapping(path = "/test")
    void test() {

        System.out.println("Test");

    }

    @RequestMapping(path = "/postProduct", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Response postProduct(@RequestBody ProductVO productVO) throws Exception {

        try {

            logger.

            logger.info("product_name: " + productVO.getName());
            logger.info("space_used: " + productVO.getSpace());
            logger.info("product_value: " + productVO.getValue());
            logger.info("stock_quantity: " + productVO.getQuantity());

            return Response.status(200).entity(productVO).build();

        } catch (Exception e) {
            throw new NotFoundException(e.getMessage());
        }
    }

//    @POST
//    @Path("products")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response createNewProduct(ProductRequest productRequest) {
//
//        ProductVO product;
//
//        if (null != productRequest.parentId) {
//            try {
//                product = cargoService.createNewProduct(productRequest.amount, productRequest.type, productRequest.parentId);
//            } catch (Exception e) {
//                throw new NotAcceptableException(e.getMessage());
//            }
//
//        } else
//            product = cargoService.createNewProduct(productRequest.amount, productRequest.type);
//
//        return Response.status(201).
//                header("Location", uri.getBaseUri() + "transportanalysis/products/" + product.getId())
//                .build();
//
//    }
}
