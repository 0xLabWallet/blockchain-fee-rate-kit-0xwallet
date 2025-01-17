package com.wallet0x.feeratekit

import com.wallet0x.feeratekit.model.FeeProviderConfig
import com.wallet0x.feeratekit.providers.EvmProvider
import com.wallet0x.feeratekit.providers.MempoolSpaceProvider
import io.reactivex.Single
import java.math.BigInteger

class FeeRateKit(providerConfig: FeeProviderConfig) {

    private val mempoolSpaceProvider = MempoolSpaceProvider(providerConfig.mempoolSpaceUrl)
    private val ethProvider = EvmProvider(providerConfig.ethEvmUrl, providerConfig.ethEvmAuth)
    private val bscProvider = EvmProvider(providerConfig.bscEvmUrl)

    fun bitcoin(): Single<MempoolSpaceProvider.RecommendedFees> {
        return mempoolSpaceProvider.getFeeRate()
    }

    fun litecoin(): Single<BigInteger> {
        return Single.just(BigInteger("1"))
    }

    fun bitcoinCash(): Single<BigInteger> {
        return Single.just(BigInteger("3"))
    }

    fun dash(): Single<BigInteger> {
        return Single.just(BigInteger("1"))
    }

    fun ethereum(): Single<BigInteger> {
        return ethProvider.getFeeRate()
    }

    fun binanceSmartChain(): Single<BigInteger> {
       return bscProvider.getFeeRate()
    }
}
