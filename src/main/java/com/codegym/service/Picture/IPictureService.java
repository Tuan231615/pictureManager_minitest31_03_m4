package com.codegym.service.Picture;

import com.codegym.model.Catalog;
import com.codegym.model.Picture;
import com.codegym.service.IGeneralService;
import com.sun.org.apache.bcel.internal.classfile.Code;

import java.util.Optional;

public interface IPictureService extends IGeneralService<Picture> {
    Iterable<Picture> findAllByCatalog(Optional<Catalog> catalog);
    Iterable<Picture>findAllByCode(Code code);
}
