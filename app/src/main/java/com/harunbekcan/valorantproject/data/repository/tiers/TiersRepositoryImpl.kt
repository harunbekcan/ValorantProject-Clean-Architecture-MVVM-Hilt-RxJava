package com.harunbekcan.valorantproject.data.repository.tiers

import com.harunbekcan.valorantproject.data.api.ServiceInterface
import com.harunbekcan.valorantproject.data.response.tiers.TiersResponse
import io.reactivex.rxjava3.core.Single

class TiersRepositoryImpl(private val serviceInterface: ServiceInterface) : TiersRepository {

    override fun getTiers(): Single<TiersResponse> {
        return serviceInterface.getTiers()
    }
}