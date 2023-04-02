package com.codegym.controller;

import com.codegym.model.Catalog;
import com.codegym.service.Catalog.ICatalogService;
import com.codegym.service.Picture.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CatalogController{
    @Autowired
    private IPictureService pictureService;
    @Autowired
    private ICatalogService catalogService;
    @GetMapping("/catalogs")
    public ModelAndView listCatalogs(){
        Iterable<Catalog> catalogs = catalogService.findAll();
        ModelAndView modelAndView = new ModelAndView("/catalog/list");
        modelAndView.addObject("catalogs", catalogs);
        return modelAndView;
    }
    @GetMapping("/create-catalog")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("/catalog/create");
        modelAndView.addObject("catalog", new Catalog());
        return modelAndView;
    }
    @PostMapping("/create-catalog")
    public ModelAndView saveCatalog(@ModelAttribute("catalog") Catalog catalog){
        catalogService.save(catalog);
        ModelAndView modelAndView = new ModelAndView("/catalog/create");
        modelAndView.addObject("catalog", new Catalog());
        modelAndView.addObject("message", "create catalog successfully!");
        return modelAndView;
    }
}
