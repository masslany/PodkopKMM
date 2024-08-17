package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.network.models.common.EmbedDto
import pl.masslany.business.common.domain.models.common.Embed
import pl.masslany.common.kotlin.mapper.Mapper

interface EmbedMapper : Mapper<EmbedDto, Embed>

class EmbedMapperImpl : EmbedMapper {
    override fun map(param: EmbedDto): Embed {
        return Embed(
            key = param.key,
            thumbnail = param.thumbnail.orEmpty(),
            url = param.url,
            // TODO: Type domain model & mapper
            type = param.type,
        )
    }
}
