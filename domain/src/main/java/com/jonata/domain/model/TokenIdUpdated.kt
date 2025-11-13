package com.jonata.domain.model

import javax.inject.Inject

data class TokenIdUpdated (
     var tokenType: String,
     var refreshToken: String,
     var expiresIn: Long,
     var idToken: String,
)