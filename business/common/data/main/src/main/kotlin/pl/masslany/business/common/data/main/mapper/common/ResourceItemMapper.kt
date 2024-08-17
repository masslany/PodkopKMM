package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.main.mapper.ResourceMapper
import pl.masslany.business.common.data.network.models.common.ResourceItemDto
import pl.masslany.business.common.domain.models.common.ResourceItem
import pl.masslany.common.kotlin.mapper.Mapper

interface ResourceItemMapper : Mapper<List<ResourceItemDto>, List<ResourceItem>>

@Suppress("LongParameterList")
class ResourceItemMapperImpl(
    private val actionsMapper: ActionsMapper,
    private val authorMapper: AuthorMapper,
    private val commentsMapper: CommentsMapper,
    private val mediaMapper: MediaMapper,
    private val sourceMapper: SourceMapper,
    private val votesMapper: VotesMapper,
    private val resourceMapper: ResourceMapper,
    private val deletedMapper: DeletedMapper,
) : ResourceItemMapper {
    override fun map(param: List<ResourceItemDto>): List<ResourceItem> {
        return param.map {
            ResourceItem(
                actions = it.actions?.let { actionsDto -> actionsMapper.map(actionsDto) },
                adult = it.adult ?: false,
                archive = it.archive ?: false,
                author = it.author?.let { authorDto -> authorMapper.map(authorDto) },
                comments = it.comments?.let { commentsDto -> commentsMapper.map(commentsDto) },
                content = it.content.orEmpty(),
                createdAt = it.createdAt,
                deletable = it.deletable ?: false,
                deleted = deletedMapper.map(it.deleted),
                description = it.description.orEmpty(),
                editable = it.editable ?: false,
                hot = it.hot ?: false,
                id = it.id ?: -1,
                media = it.media?.let { mediaDto -> mediaMapper.map(mediaDto) },
                name = it.name.orEmpty(),
                publishedAt = it.publishedAt,
                recommended = it.recommended ?: false,
                resource = resourceMapper.map(it.resource),
                slug = it.slug.orEmpty(),
                source = it.source?.let { source -> sourceMapper.map(source) },
                tags = it.tags ?: emptyList(),
                title = it.title.orEmpty(),
                voted = it.voted == 1,
                votes = it.votes?.let { votesDto -> votesMapper.map(votesDto) },
            )
        }
    }
}
