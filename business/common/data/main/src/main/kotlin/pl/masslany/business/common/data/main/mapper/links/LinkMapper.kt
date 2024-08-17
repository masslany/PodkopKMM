package pl.masslany.business.common.data.main.mapper.links

import pl.masslany.business.common.data.main.mapper.common.toResourceItem
import pl.masslany.business.common.data.network.models.common.SingleResourceResponseDto
import pl.masslany.business.common.domain.models.links.Link

fun SingleResourceResponseDto.toLink(): Link =
    Link(
        data = data.toResourceItem(),
    )