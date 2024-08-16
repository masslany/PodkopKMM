package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.network.models.common.SourceDto
import pl.masslany.business.common.domain.models.common.Source
import pl.masslany.common.kotlin.mapper.Mapper

interface SourceMapper : Mapper<SourceDto, Source>

class SourceMapperImpl : SourceMapper {
    override fun map(param: SourceDto): Source {
        return Source(
            label = param.label,
            // TODO: Domain model & mapper
            type = param.type.orEmpty(),
            typeId = param.typeId ?: -1,
            url = param.url,
        )
    }
}
