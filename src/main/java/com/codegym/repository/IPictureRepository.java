package com.codegym.repository;

import com.codegym.model.Catalog;
import com.codegym.model.Picture;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPictureRepository extends PagingAndSortingRepository<Picture, Long> {
    Iterable<Picture>findAllByCatalog(Optional<Catalog> catalog);
    Iterable<Picture>findAllByCode(Code code);
}
