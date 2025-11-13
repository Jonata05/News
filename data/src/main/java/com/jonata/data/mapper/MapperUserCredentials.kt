package com.jonata.data.mapper

import com.jonata.data.model.UserCredentialsData
import com.jonata.domain.model.UserCredentials


fun UserCredentials.toData() =
    UserCredentialsData(this.email.get(),this.password.get())
