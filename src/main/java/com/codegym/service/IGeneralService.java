package com.codegym.service;

import com.codegym.model.Picture;
import com.sun.tools.javac.jvm.Code;

import java.util.Optional;

public interface IGeneralService<T>{
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    void save(T t);
    void remove(Long id);
}
