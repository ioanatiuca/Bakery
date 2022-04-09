package com.bakery.finalproject.mapper;

public interface Mapper<E,T> {
    public T entityToDTO (E entity);
    public E DTOToEntity (T dto);
}
