package com.jonata.domain.ErrorDomain

sealed class DomainError constructor(private val updateMessage: String) {

    var getMessage: String = updateMessage
        private set

    data class NetworkError(val code: Int? = null) : DomainError("")
    data class ServerError(val code: Int? = null, val message: String? = null) : DomainError("")
    data class Unauthorized(val message: String? = null) : DomainError("")
    data class Forbidden(val message: String? = null) : DomainError("")
    data class NotFound(val message: String? = null) : DomainError("")
    data class BadRequest(val message: String? = null) : DomainError("")
    data class ParsingError(val message: String? = null) : DomainError("")
    data class LocalDatabaseError(val message: String? = null) : DomainError("")
    data class Unknown(val exception: Exception) : DomainError("")


}