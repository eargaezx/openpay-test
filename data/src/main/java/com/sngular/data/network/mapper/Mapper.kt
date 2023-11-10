package com.sngular.data.network.mapper

interface Mapper<A, B> {
    fun mapToEntity(type: A): B
}