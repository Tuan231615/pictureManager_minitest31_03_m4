package com.codegym.controller;

import com.codegym.model.Catalog;
import com.codegym.model.Picture;
import com.codegym.model.PictureForm;
import com.codegym.service.Catalog.ICatalogService;
import com.codegym.service.Picture.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
public class PictureController {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private IPictureService pictureService;
    @Autowired
    private ICatalogService catalogService;
    @Autowired
    private HttpSession httpSession;
    @ModelAttribute("catalogs")
    public Iterable<Catalog> catalogs(){
        return catalogService.findAll();
    }
    @GetMapping("/create-picture")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("/picture/create");
        modelAndView.addObject("picture", new Picture());
            return modelAndView;
    }
    @PostMapping("/create-picture")
    public ModelAndView savePicture(@ModelAttribute PictureForm pictureForm){
        MultipartFile multipartFile = pictureForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try{
            FileCopyUtils.copy(pictureForm.getImage().getBytes(), new File(fileUpload + fileName));
        }catch (IOException e){
            e.printStackTrace();
        }
        Picture picture = new Picture(pictureForm.getId(), pictureForm.getCode(), pictureForm.getHeight(), pictureForm.getWide(),
                pictureForm.getMaterial(), pictureForm.getDescription(), pictureForm.getPrice(), pictureForm.getCatalog(), fileName);
        pictureService.save(picture);
        ModelAndView modelAndView = new ModelAndView("/picture/create");
        modelAndView.addObject("picture", new Picture());
        modelAndView.addObject("message", "create picture successfully!");

        return modelAndView;
    }
    @GetMapping("/pictures")
    public ModelAndView listPictures(@RequestParam("search") Optional<String> search, @RequestParam("searchSearch") Optional<Catalog> catalog, Pageable pageable) {
        Page<Picture> picturePage;
        if (search.isPresent()){
            picturePage = pictureService.findAllByCodeAndCatalog(search.get(), catalog ,pageable);
        }else {
            picturePage = pictureService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/picture/list");
        modelAndView.addObject("pictures", picturePage);
        return modelAndView;
    }
    @GetMapping("/edit-picture/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Picture> pictureOptional = pictureService.findById(id);
        if (pictureOptional.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/picture/edit");
            modelAndView.addObject("picture", pictureOptional.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/edit-picture")
    public ModelAndView updatePicture(@ModelAttribute PictureForm pictureForm) {
        MultipartFile multipartFile = pictureForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try{
            FileCopyUtils.copy(pictureForm.getImage().getBytes(), new File(fileUpload + fileName));
        }catch (IOException e){
            e.printStackTrace();
        }
        Picture picture = new Picture(pictureForm.getId(), pictureForm.getCode(), pictureForm.getHeight(), pictureForm.getWide(),
                pictureForm.getMaterial(), pictureForm.getDescription(), pictureForm.getPrice(), pictureForm.getCatalog(), fileName);
        pictureService.save(picture);
        ModelAndView modelAndView = new ModelAndView("/picture/edit");
        modelAndView.addObject("picture", picture);
        modelAndView.addObject("message", "picture updated successfully");
        httpSession.setAttribute("picture", picture);
        return modelAndView;
    }

    @GetMapping("/delete-picture/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Picture> picture = pictureService.findById(id);
        if (picture.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/picture/delete");
            modelAndView.addObject("picture", picture.get());
            return modelAndView;

        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/delete-picture")
    public String deletePicture(@ModelAttribute("picture") Picture picture) {
        pictureService.remove(picture.getId());
        return "redirect:pictures";
    }

    @GetMapping("/view-picture/{id}")
    public ModelAndView viewPicture(@PathVariable Long id){
        Optional<Picture> picture = pictureService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/picture/view");
        modelAndView.addObject("picture", picture);
        return modelAndView;
    }

    @GetMapping("/viewSession")
    public ModelAndView viewSession(){
        ModelAndView modelAndView = new ModelAndView("/picture/edit");
        Picture picture = (Picture) httpSession.getAttribute("picture");
        modelAndView.addObject("picture", picture);
        return modelAndView;
    }
}
