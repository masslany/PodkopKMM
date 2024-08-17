package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.network.models.common.ResourceResponseDto
import pl.masslany.business.common.domain.models.common.Resources
import pl.masslany.common.kotlin.mapper.Mapper

interface ResourcesMapper : Mapper<ResourceResponseDto, Resources>

class ResourcesMapperImpl(
    private val resourceItemMapper: ResourceItemMapper,
    private val paginationMapper: PaginationMapper,
) : ResourcesMapper {
    override fun map(param: ResourceResponseDto): Resources {
        return Resources(
            data = resourceItemMapper.map(param.data),
            pagination = param.pagination?.let { paginationMapper.map(it) },
        )
    }
}
