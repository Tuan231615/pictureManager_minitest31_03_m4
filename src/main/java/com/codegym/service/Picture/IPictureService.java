package com.codegym.service.Picture;

import com.codegym.model.Catalog;
import com.codegym.model.Picture;
import com.codegym.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IPictureService extends IGeneralService<Picture>{
    Page<Picture> findAllByCatalog(Optional<Catalog> catalog, Pageable pageable);
    Page<Picture> findAll(Pageable pageable);

}
