package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.main.mapper.ResourceMapper
import pl.masslany.business.common.data.network.models.comments.CommentItemDto
import pl.masslany.business.common.domain.models.common.Comment
import pl.masslany.common.kotlin.mapper.Mapper

interface CommentItemMapper : Mapper<List<CommentItemDto>, List<Comment>>

@Suppress("LongParameterList")
class CommentItemMapperImpl(
    private val actionsMapper: ActionsMapper,
    private val authorMapper: AuthorMapper,
    private val mediaMapper: MediaMapper,
    private val votesMapper: VotesMapper,
    private val resourceMapper: ResourceMapper,
    private val deletedMapper: DeletedMapper,
) : CommentItemMapper {
    override fun map(param: List<CommentItemDto>): List<Comment> {
        return param.map {
            Comment(
                actions = actionsMapper.map(it.actions),
                adult = it.adult,
                archive = it.archive,
                author = authorMapper.map(it.author),
                comments = none(),
                createdAt = it.createdAt,
                deletable = it.deletable,
                editable = it.editable,
                id = it.id,
                media = mediaMapper.map(it.media),
                resource = resourceMapper.map(it.resource),
                slug = it.slug,
                tags = it.tags,
                voted = it.voted,
                votes = votesMapper.map(it.votes),
                content = it.content,
                blacklist = it.blacklist,
                deleted = deletedMapper.map(it.deleted),
                device = it.device,
                favourite = it.favourite,
                parentId = it.parentId ?: -1,
            )
        }
    }
}
