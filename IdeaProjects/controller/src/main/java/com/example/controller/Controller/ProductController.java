package com.example.controller.Controller;

import com.example.controller.Model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    @RequestMapping("/product")
    public String showProduct(Model model) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Trà sữa truyền thống", 25000));
        products.add(new Product(2, "Trà sữa trân châu", 30000));
        products.add(new Product(3, "Trà sữa matcha", 35000));
        model.addAttribute("products", products);
        return "/product";

    }
}
