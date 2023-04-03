package com.codegym.repository;

import com.codegym.model.Catalog;
import com.codegym.model.Picture;
import com.sun.tools.javac.jvm.Code;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPictureRepository extends PagingAndSortingRepository<Picture, Long> {
    Page<Picture> findAllByCatalog(Optional<Catalog> catalog, Pageable pageable);
    Page<Picture> findAllByCodeAndCatalog(String code, Optional<Catalog> catalog, Pageable pageable);
}
