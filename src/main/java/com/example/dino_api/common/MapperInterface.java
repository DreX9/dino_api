package com.example.dino_api.common;

public interface MapperInterface <E, DW, DV>{
    DV toDt(E entity);
    E toEntity(DW dto);
}
