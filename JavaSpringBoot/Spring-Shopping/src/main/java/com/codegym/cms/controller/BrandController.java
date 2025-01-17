package com.codegym.cms.controller;

import com.codegym.cms.model.Brand;
import com.codegym.cms.model.Product;
import com.codegym.cms.service.BrandService;
import com.codegym.cms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@ComponentScan("com.codegym.cms")
@RestController
@RequestMapping("/admin")
public class BrandController {
    @Autowired
    private BrandService brandService;
    @Autowired
    private ProductService productService;

    @GetMapping("/list-brand")
    public ModelAndView BrandList() {
        Iterable<Brand> brands = brandService.findAll();
        ModelAndView modelAndView = new ModelAndView("/brand/list");
        modelAndView.addObject("brands", brands);
        return modelAndView;
    }

    @GetMapping("/create-brand")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/brand/create");
        modelAndView.addObject("brand", new Brand());
        return modelAndView;
    }

    @PostMapping("/create-brand")
    public ModelAndView saveBrand(@Validated @ModelAttribute("brand") Brand brand) {
        brandService.save(brand);

        ModelAndView modelAndView = new ModelAndView("/brand/create");
        modelAndView.addObject("brand", new Brand());
        modelAndView.addObject("message", "New brand created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-brand/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Brand brand = brandService.findById(id);
        if (brand != null) {
            ModelAndView modelAndView = new ModelAndView("/brand/edit");
            modelAndView.addObject("brand", brand);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/layout/404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-brand")
    public ModelAndView updateBrand(@Validated @ModelAttribute("brand") Brand brand) {
        brandService.save(brand);
        ModelAndView modelAndView = new ModelAndView("/brand/edit");
        modelAndView.addObject("brand", brand);
        modelAndView.addObject("message", "Brand updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-brand/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Brand brand = brandService.findById(id);
        if (brand != null) {
            ModelAndView modelAndView = new ModelAndView("/brand/delete");
            modelAndView.addObject("brand", brand);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/layout/404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-brand")
    public String deleteBrand(@ModelAttribute("brand") Brand brand) {
        brandService.sortDelete(brand.getId());
        return "redirect:/admin/list-brand";
    }


    @GetMapping("/view-brand/{id}")
    public ModelAndView viewBrand(@PathVariable("id") Long id) {
        Brand brand = brandService.findById(id);
        if (brand == null) {
            return new ModelAndView("/layout/404");
        }

        Iterable<Product> products = productService.findAllByBrand(brand);

        ModelAndView modelAndView = new ModelAndView("/brand/view");
        modelAndView.addObject("brand", brand);
        modelAndView.addObject("products", products);
        return modelAndView;
    }
}

