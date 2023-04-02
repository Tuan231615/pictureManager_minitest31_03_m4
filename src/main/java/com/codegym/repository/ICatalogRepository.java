package com.codegym.repository;

import com.codegym.model.Catalog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICatalogRepository extends PagingAndSortingRepository<Catalog, Long> {
}
