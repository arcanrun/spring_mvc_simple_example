package com.geekbrains.controllers;


import com.geekbrains.entities.Product;
import com.geekbrains.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    private void setProductService(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("")
    public String showAllProduct(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "all_products";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addNewProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add_new_product";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewProduct(Product product) {

        productService.addProduct(product.getPrice(), product.getTitle());
        return "redirect:/products";
    }

    @GetMapping("/{id}")
    public String showProductById(Model model, @PathVariable int id){
        Product product = productService.findById(id);
        if(product == null){
            return "redirect:/404/";
        }
        System.out.println(product);
        model.addAttribute("product", product);
        return "product_page";
    }
    @PostMapping("/change")
    public String changeProduct(@ModelAttribute("product") Product product){
        System.out.println("change: "+product);
        productService.changeProductById(product.getId(), product);
        return "product_page";
    }


}
