package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.main.mapper.GenderMapper
import pl.masslany.business.common.data.main.mapper.NameColorMapper
import pl.masslany.business.common.data.network.models.common.AuthorDto
import pl.masslany.business.common.domain.models.common.Author
import pl.masslany.common.kotlin.mapper.Mapper

interface AuthorMapper : Mapper<AuthorDto, Author>

class AuthorMapperImpl(
    private val rankMapper: RankMapper,
    private val nameColorMapper: NameColorMapper,
    private val genderMapper: GenderMapper,
) : AuthorMapper {
    override fun map(param: AuthorDto): Author {
        return Author(
            avatar = param.avatar,
            blacklist = param.blacklist,
            color = nameColorMapper.map(param.color),
            company = param.company,
            follow = param.follow,
            gender = genderMapper.map(param.gender),
            note = param.note,
            online = param.online,
            rank = rankMapper.map(param.rank),
            status = param.status,
            username = param.username,
            verified = param.verified,
        )
    }
}
