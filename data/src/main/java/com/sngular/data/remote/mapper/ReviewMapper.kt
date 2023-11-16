package com.sngular.data.remote.mapper

import com.sngular.data.local.entity.ReviewEntity
import com.sngular.data.remote.dto.ReviewDto
import com.sngular.domain.model.Review

object ReviewMapper : Mapper<ReviewEntity, ReviewDto, Review> {
    override fun dtoToModel(input: ReviewDto) = with(input) {
        Review(
            author = author,
            content = content
        )
    }

    override fun modelToEntity(input: Review) = with(input) {
        ReviewEntity(
            author = author!!,
            content = content!!
        )
    }

    override fun entityToModel(input: ReviewEntity) = with(input) {
        Review(
            author = author,
            content = content
        )
    }

}