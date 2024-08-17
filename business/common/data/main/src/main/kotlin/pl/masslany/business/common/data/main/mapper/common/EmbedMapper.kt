package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.network.models.common.EmbedDto
import pl.masslany.business.common.domain.models.common.Embed


fun EmbedDto.toEmbed(): Embed {
    return Embed(
        key = key,
        thumbnail = thumbnail.orEmpty(),
        url = url,
        // TODO: Type domain model & mapper
        type = type,
    )
}
