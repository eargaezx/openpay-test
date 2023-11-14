package com.sngular.data.remote.datasource

import com.sngular.data.remote.api.StatusCode
import com.sngular.data.remote.api.ApiService
import com.sngular.data.remote.mapper.PeopleImageMapper
import com.sngular.data.remote.mapper.PeopleMapper
import com.sngular.data.remote.mapper.ReviewMapper
import com.sngular.domain.datasource.remote.PeopleRemoteDatasource
import javax.inject.Inject
import com.sngular.domain.state.Result
import com.sngular.domain.model.People
import com.sngular.domain.model.PeopleImage


class PeopleRemoteDatasourceImpl @Inject constructor(
    private val apiService: ApiService
) : PeopleRemoteDatasource {
    override suspend fun getPopular(): Result<People> {
        return try {
            val responsePeople = apiService.getPopularPeople()
            when (responsePeople.code()) {
                StatusCode.SUCCESS.code -> {
                    val people = PeopleMapper.dtoToModel(
                        responsePeople.body()!!.results!!.first()
                    )

                    val responseImages = apiService.getPeopleImages(people.id)
                    if(responseImages.code() == StatusCode.SUCCESS.code){
                        people.peopleImages =
                            responseImages.body()!!.profiles!!.map { PeopleImageMapper.dtoToModel(it) }
                    }

                    val responseReviews = apiService.getReviews(1)
                    if(responseImages.code() == StatusCode.SUCCESS.code){
                        people.reviews =
                            responseReviews.body()!!.results!!.map { ReviewMapper.dtoToModel(it) }
                    }

                    Result.Success(people)
                }

                else -> Result.Error(responsePeople.message())
            }
        } catch (e: Exception) {
            Result.Error(e.message ?: e.toString())
        }
    }

    override suspend fun getImages(peopleId: Int): Result<List<PeopleImage>> {
        return try {
            val response = apiService.getPeopleImages(peopleId)
            when (response.code()) {
                StatusCode.SUCCESS.code -> {
                    Result.Success(
                        response.body()!!.profiles!!.map {
                            PeopleImageMapper.dtoToModel(it)
                        }
                    )
                }

                else -> Result.Error(response.message())
            }
        } catch (e: Exception) {
            Result.Error(e.message ?: e.toString())
        }
    }


}