package com.codegym.service.Picture;

import com.codegym.model.Catalog;
import com.codegym.model.Picture;
import com.codegym.repository.IPictureRepository;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PictureService implements IPictureService {
    @Autowired
    private IPictureRepository pictureRepository;


    @Override
    public Page<Picture> findAll(Pageable pageable) {
        return pictureRepository.findAll(pageable);
    }

    @Override
    public Page<Picture> findAllByCodeAndCatalog(String code, Optional<Catalog> catalog, Pageable pageable) {
        return pictureRepository.findAllByCodeAndCatalog(code, catalog, pageable);
    }

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
    public Page<Picture> findAllByCatalog(Optional<Catalog> catalog, Pageable pageable) {
        return pictureRepository.findAllByCatalog(catalog, pageable);
    }

}
