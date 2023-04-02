package com.codegym.formatter;

import com.codegym.model.Catalog;
import com.codegym.model.Picture;
import com.codegym.service.Catalog.CatalogService;
import com.codegym.service.Picture.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;
@Component
public class CatalogFormatter implements Formatter<Catalog> {
    private CatalogService catalogService;
    @Autowired
    public CatalogFormatter(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @Override
    public Catalog parse(String id, Locale locale) throws ParseException {
        Optional<Catalog> catalogOptional = catalogService.findById(Long.parseLong(id));
        return catalogOptional.orElse(null);
    }

    @Override
    public String print(Catalog object, Locale locale) {
        return "[" + object.getC_id() + ", " +object.getName() + "]";
    }
}
