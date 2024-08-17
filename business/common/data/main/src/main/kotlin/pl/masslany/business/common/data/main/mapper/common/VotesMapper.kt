package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.network.models.common.VotesDto
import pl.masslany.business.common.domain.models.common.Votes

fun VotesDto.toVotes(): Votes =
    Votes(
        count = count ?: 0,
        down = down,
        up = up,
    )