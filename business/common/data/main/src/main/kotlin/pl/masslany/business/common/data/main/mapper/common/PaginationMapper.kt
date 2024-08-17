package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.network.models.common.PaginationDto
import pl.masslany.business.common.domain.models.common.Pagination
import pl.masslany.common.kotlin.mapper.Mapper

interface PaginationMapper : Mapper<PaginationDto, Pagination>

class PaginationMapperImpl : PaginationMapper {
    override fun map(param: PaginationDto): Pagination {
        return Pagination(
            perPage = param.perPage ?: 0,
            total = param.total ?: 0,
            next = param.next.orEmpty(),
            prev = param.prev.orEmpty(),
        )
    }
}
