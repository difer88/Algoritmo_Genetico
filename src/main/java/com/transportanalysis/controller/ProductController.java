package main.java.com.transportanalysis.controller;

import main.java.com.transportanalysis.enumeration.ApiMessages;
import main.java.com.transportanalysis.models.ProductVO;
import main.java.com.transportanalysis.response.ResponseMessage;
import main.java.com.transportanalysis.services.cargo.CargoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;

@RestController
@RequestMapping(path = "/transportanalysis")
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected CargoService cargoService;

    @RequestMapping(path = "/postProduct", method = RequestMethod.POST)
    @Produces("application/json")
    public ResponseMessage postProduct(@RequestBody ProductVO productVO) throws BeanCreationException {

        try {

            logger.info("product_name: " + productVO.getName());
            logger.info("space_used: " + productVO.getSpace());
            logger.info("product_value: " + productVO.getValue());
            logger.info("stock_quantity: " + productVO.getQuantity());

            return ResponseMessage.createMessage(ApiMessages.SUCCESS, ApiMessages.CREATE_PRODUCT_SUCCESS);

        } catch (Exception e) {
            throw new BeanCreationException(ApiMessages.CREATE_PRODUCT_ERROR);
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
