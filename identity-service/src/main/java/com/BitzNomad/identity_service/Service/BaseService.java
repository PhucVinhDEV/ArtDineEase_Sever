package com.BitzNomad.identity_service.Service;

import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public interface BaseService<D,E,V> {

    D findById(V id);

    D save(E entity);

    D update(E entity);

    void deleteById(V id);

    Iterator<D> findAll();

}
