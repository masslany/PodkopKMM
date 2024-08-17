package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.network.models.common.RankDto
import pl.masslany.business.common.domain.models.common.Rank

fun RankDto.toRank(): Rank {
    return Rank(
        position = position ?: 0,
        trend = trend,
    )
}
