package main.java.com.transportanalysis.test.controller;

import main.java.com.transportanalysis.test.services.cargo.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping(path = "/transportanalysis")
public class CargoController {

    @Autowired
    protected CargoService cargoService;

    @GetMapping(path = "/test")
    void test() {

        System.out.println("Test");

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("cargo/{id}")
    public void getCargoById(@PathParam("id") long id) throws Exception {

        try {

            System.out.println("ID: " + id);

//            return Response.status(201).
//                    header("Location", uri.getBaseUri() + "transportanalysis/products/")
//                    .build();
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
//        Product product;
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
