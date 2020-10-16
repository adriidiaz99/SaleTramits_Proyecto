package com.salesianostriana.SalesTrami.servicio.BaseService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BaseService<T, ID> {

    T save(T t);

    T findById(ID id);

    List<T> findAll();

    T edit(T t);

    void delete(T t);

    void deleteById(ID id);
}
