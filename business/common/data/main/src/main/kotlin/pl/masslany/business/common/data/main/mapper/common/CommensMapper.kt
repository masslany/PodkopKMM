package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.network.models.common.CommentsDto
import pl.masslany.business.common.domain.models.common.Comments
import pl.masslany.common.kotlin.mapper.Mapper

interface CommentsMapper : Mapper<CommentsDto, Comments>

class CommentsMapperImpl(
    private val commentItemMapper: CommentItemMapper,
) : CommentsMapper {
    override fun map(param: CommentsDto): Comments {
        return Comments(
            count = param.count,
            hot = param.hot ?: false,
            items = param.items?.let { commentItemMapper.map(it) } ?: emptyList(),
        )
    }
}
