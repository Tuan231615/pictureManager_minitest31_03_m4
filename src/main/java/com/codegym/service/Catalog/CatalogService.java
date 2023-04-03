package com.codegym.service.Catalog;
import com.codegym.model.Catalog;
import com.codegym.repository.ICatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CatalogService implements ICatalogService{
    @Autowired
    private ICatalogRepository catalogRepository;


    @Override
    public Iterable<Catalog> findAll() {
        return catalogRepository.findAll();
    }

    @Override
    public Optional<Catalog> findById(Long id) {
        return catalogRepository.findById(id);
    }

    @Override
    public void save(Catalog catalog) {
        catalogRepository.save(catalog);
    }

    @Override
    public void remove(Long id) {
        catalogRepository.deleteById(id);
    }
}
