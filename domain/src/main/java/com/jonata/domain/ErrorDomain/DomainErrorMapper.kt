package com.jonata.domain.ErrorDomain

object DomainErrorMapper {

    fun map(exception: Exception): DomainError {
        return when (exception) {
            is java.net.UnknownHostException,
            is java.net.SocketTimeoutException,
            is java.net.ConnectException,
            is java.io.IOException -> DomainError.NetworkError()

            is android.database.SQLException -> DomainError.LocalDatabaseError()
            else -> DomainError.Unknown(exception)
        }
    }
}
