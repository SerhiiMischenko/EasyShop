package com.shop.services;

import com.shop.models.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private Long ID = 0L;

    {
        products.add(new Product(ID++, "zip", "some", 12, "KH", "Serj"));
        products.add(new Product(ID++, "lol", "some", 555, "BH", "Lana"));
        products.add(new Product(ID++, "kek", "some", 999, "TK", "Pama"));
    }

    public List<Product> listProducts() {
        return products;
    }

    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public void saveProduct(Product product) {
        product.setId(ID++);
        products.add(product);
    }

    public void deleteProduct(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }
}
