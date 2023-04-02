package com.codegym.formatter;

import com.codegym.model.Picture;
import com.codegym.service.Picture.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;
@Component
public class PictureFormatter implements Formatter<Picture> {
    private PictureService pictureService;
    @Autowired
    public PictureFormatter(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @Override
    public Picture parse(String text, Locale locale) throws ParseException {
        Optional<Picture> pictureOptional = pictureService.findById(Long.parseLong(text));
        return pictureOptional.orElse(null);
    }

    @Override
    public String print(Picture object, Locale locale) {
        return null;
    }
}
