package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.network.models.common.RankDto
import pl.masslany.business.common.domain.models.common.Rank
import pl.masslany.common.kotlin.mapper.Mapper

interface RankMapper : Mapper<RankDto, Rank>

class RankMapperImpl : RankMapper {
    override fun map(param: RankDto): Rank {
        return Rank(
            position = param.position ?: 0,
            trend = param.trend,
        )
    }
}
