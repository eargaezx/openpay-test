package com.sngular.data.network.mapper

interface Mapper<A, B> {
    fun mapToEntity(input: A): B
}