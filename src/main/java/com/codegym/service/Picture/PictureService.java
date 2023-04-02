package com.codegym.service.Picture;

import com.codegym.model.Catalog;
import com.codegym.model.Picture;
import com.codegym.repository.IPictureRepository;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PictureService implements IPictureService {
    @Autowired
    private IPictureRepository pictureRepository;
    @Override
    public Iterable<Picture> findAll() {
        return pictureRepository.findAll();
    }

    @Override
    public Optional<Picture> findById(Long id) {
        return pictureRepository.findById(id);
    }

    @Override
    public void save(Picture picture) {
        pictureRepository.save(picture);
    }

    @Override
    public void remove(Long id) {
        pictureRepository.deleteById(id);
    }

    @Override
    public Iterable<Picture> findAllByCode(Code code) {
        return null;
    }

    @Override
    public Iterable<Picture> findAllByCatalog(Optional<Catalog> catalog) {
        return pictureRepository.findAllByCatalog(catalog);
    }
}
