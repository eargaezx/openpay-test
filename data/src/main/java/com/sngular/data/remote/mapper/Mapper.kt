package com.sngular.data.remote.mapper
/*
*A:Entity
* B:DTO
* C: MODEL
 */
interface Mapper<A, B, C> {
    fun dtoToModel(type: B): C
    fun modelToEntity(type: C): A

    fun entityToModel(type: A): C
}