package pl.masslany.business.common.data.main.mapper.links

import pl.masslany.business.common.data.main.mapper.common.ResourceItemMapper
import pl.masslany.business.common.data.network.models.common.SingleResourceResponseDto
import pl.masslany.business.common.domain.models.links.Link
import pl.masslany.common.kotlin.mapper.Mapper

interface LinkMapper : Mapper<SingleResourceResponseDto, Link>

class LinkMapperImpl(
    private val resourceItemMapper: ResourceItemMapper,
) : LinkMapper {
    override fun map(param: SingleResourceResponseDto): Link {
        return Link(
            data = resourceItemMapper.map(listOf(param.data)).first(),
        )
    }
}
