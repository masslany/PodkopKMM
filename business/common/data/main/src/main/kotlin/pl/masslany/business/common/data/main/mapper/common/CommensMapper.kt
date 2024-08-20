package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.network.models.common.CommentsDto
import pl.masslany.business.common.domain.models.common.Comments

fun CommentsDto.toComments(): Comments =
    Comments(
        count = count,
        hot = hot ?: false,
        items = items?.map { it.toComment() } ?: emptyList(),
    )
