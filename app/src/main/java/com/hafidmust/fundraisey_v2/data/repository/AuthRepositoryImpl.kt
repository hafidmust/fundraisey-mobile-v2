package com.hafidmust.fundraisey_v2.data.repository

import com.hafidmust.fundraisey_v2.data.source.remote.RemoteDataSource
import com.hafidmust.fundraisey_v2.domain.model.auth.Login
import com.hafidmust.fundraisey_v2.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton
import com.hafidmust.fundraisey_v2.domain.common.Result
import com.hafidmust.fundraisey_v2.domain.model.auth.Register
import com.hafidmust.fundraisey_v2.utils.toLoginDomain
import com.hafidmust.fundraisey_v2.utils.toRegisterDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.lang.Exception

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : AuthRepository {
    override fun login(email: String, password: String): Flow<Result<Login>> = flow {
        emit(Result.Loading())
        try {
            val response = remoteDataSource.login(email, password)
            val result = response.toLoginDomain()
            emit(Result.Success(result))
        } catch (e: HttpException) {
            emit(Result.Error(e.message))
        } catch (e: Exception) {
            emit(Result.Error(e.message))
        }
    }.flowOn(Dispatchers.IO)

    override fun register(
        email: String,
        password: String,
        citizenId: String,
        fullName: String,
        gender: String,
        phoneNumber: String,
        dateOfBirth: String
    ): Flow<Result<Register>> {
        return flow {
            emit(Result.Loading())
            try {
                val response = remoteDataSource.register(email, password, citizenId, fullName, gender, phoneNumber, dateOfBirth)
                val result = response.toRegisterDomain()
                emit(Result.Success(result))
            }catch (e : Exception){
                emit(Result.Error(e.message))
            }
        }.flowOn(Dispatchers.IO)
    }

}