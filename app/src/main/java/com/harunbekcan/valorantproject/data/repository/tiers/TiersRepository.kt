package com.harunbekcan.valorantproject.data.repository.tiers

import com.harunbekcan.valorantproject.data.response.tiers.TiersResponse
import io.reactivex.rxjava3.core.Single

interface TiersRepository {

    fun getTiers(): Single<TiersResponse>
}