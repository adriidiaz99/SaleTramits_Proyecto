package com.salesianostriana.SalesTrami.servicio.BaseService;


import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<T, ID, R extends JpaRepository<T, ID>> implements BaseService<T, ID>{

    protected R repositorio;

    public BaseServiceImpl(R repo) {
        this.repositorio = repo;
    }

    @Override
    public T save(T t) {
        return repositorio.save(t);
    }


    @Override
    public T findById(ID id) {
        return repositorio.findById(id).orElse(null);
    }


    @Override
    public List<T> findAll() {
        return repositorio.findAll();
    }


    @Override
    public T edit(T t) {
        return repositorio.save(t);
    }


    @Override
    public void delete(T t) {
        repositorio.delete(t);
    }


    @Override
    public void deleteById(ID id) {
        repositorio.deleteById(id);
    }
}
