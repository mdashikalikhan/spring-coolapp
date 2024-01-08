package com.app.springcoolapp.res;

import com.app.springcoolapp.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FakeProductController {
    @GetMapping("/fake-products")
    public List<Product> getFakeProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product(1l, "Product 1", 76783));
        products.add(new Product(2l, "Product 2", 76712.21));
        return products;
    }

    @GetMapping("/fake-products/{id}")
    public Product getFakeProductById(@PathVariable("id") Long id){
        if(id==1l){
            return new Product(1l, "Product 1", 76783);
        } else if(id==2l){
            return new Product(2l, "Product 2", 76712.21);
        }
        return null;
    }
}
