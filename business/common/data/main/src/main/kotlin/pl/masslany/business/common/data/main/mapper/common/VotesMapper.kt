package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.network.models.common.VotesDto
import pl.masslany.business.common.domain.models.common.Votes
import pl.masslany.common.kotlin.mapper.Mapper

interface VotesMapper : Mapper<VotesDto, Votes>

class VotesMapperImpl : VotesMapper {
    override fun map(param: VotesDto): Votes {
        return Votes(
            // TODO: Option not default value
            count = param.count ?: 0,
            down = param.down,
            up = param.up,
        )
    }
}
