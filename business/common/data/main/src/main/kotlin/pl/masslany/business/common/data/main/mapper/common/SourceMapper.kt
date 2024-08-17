package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.network.models.common.SourceDto
import pl.masslany.business.common.domain.models.common.Source

fun SourceDto.toSource(): Source =
    Source(
        label = label,
        // TODO: Domain model & mapper
        type = type.orEmpty(),
        typeId = typeId ?: -1,
        url = url,
    )
