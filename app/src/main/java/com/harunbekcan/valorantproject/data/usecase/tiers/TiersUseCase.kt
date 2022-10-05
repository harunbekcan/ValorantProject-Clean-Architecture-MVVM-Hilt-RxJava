package com.harunbekcan.valorantproject.data.usecase.tiers

import com.harunbekcan.valorantproject.base.BaseUseCase
import com.harunbekcan.valorantproject.data.repository.tiers.TiersRepository
import com.harunbekcan.valorantproject.data.response.tiers.TiersResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class TiersUseCase @Inject constructor(
    private val tiersRepository: TiersRepository
) : BaseUseCase<TiersResponse>() {

    override fun buildUseCaseSingle(): Single<TiersResponse> {
        return tiersRepository.getTiers()
    }
}