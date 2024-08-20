package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.network.models.common.PaginationDto
import pl.masslany.business.common.domain.models.common.Pagination

fun PaginationDto.toPagination(): Pagination =
    Pagination(
        perPage = perPage ?: 0,
        total = total ?: 0,
        next = next.orEmpty(),
        prev = prev.orEmpty(),
    )