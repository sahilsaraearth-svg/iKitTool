package com.t8rin.ikittool.feature.filters.data.model

import com.jhlabs.ChannelMixFilter
import com.jhlabs.JhFilter
import com.t8rin.ikittool.core.filters.domain.model.Filter
import com.t8rin.ikittool.core.filters.domain.model.params.ChannelMixParams
import com.t8rin.ikittool.core.ksp.annotations.FilterInject
import com.t8rin.ikittool.feature.filters.data.transformation.JhFilterTransformation

@FilterInject
internal class ChannelMixFilter(
    override val value: ChannelMixParams = ChannelMixParams.Default
) : JhFilterTransformation(), Filter.ChannelMix {

    override val cacheKey: String
        get() = value.hashCode().toString()

    override fun createFilter(): JhFilter = ChannelMixFilter().apply {
        blueGreen = value.blueGreen
        redBlue = value.redBlue
        greenRed = value.greenRed
        intoR = value.intoR
        intoG = value.intoG
        intoB = value.intoB
    }

}