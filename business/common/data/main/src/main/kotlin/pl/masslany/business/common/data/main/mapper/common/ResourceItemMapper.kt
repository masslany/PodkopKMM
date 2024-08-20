package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.main.mapper.toResource
import pl.masslany.business.common.data.network.models.common.ResourceItemDto
import pl.masslany.business.common.domain.models.common.ResourceItem

fun ResourceItemDto.toResourceItem(): ResourceItem = ResourceItem(
    actions = actions?.toActions(),
    adult = adult ?: false,
    archive = archive ?: false,
    author = author?.toAuthor(),
    comments = comments?.toComments(),
    content = content.orEmpty(),
    createdAt = createdAt,
    deletable = deletable ?: false,
    deleted = deleted.toDeleted(),
    description = description.orEmpty(),
    editable = editable ?: false,
    hot = hot ?: false,
    id = id ?: -1,
    media = media?.toMedia(),
    name = name.orEmpty(),
    publishedAt = publishedAt,
    recommended = recommended ?: false,
    resource = resource.toResource(),
    slug = slug.orEmpty(),
    source = source?.toSource(),
    tags = tags ?: emptyList(),
    title = title.orEmpty(),
    voted = voted == 1,
    votes = votes?.toVotes(),
)

fun List<ResourceItemDto>.toResourceItems(): List<ResourceItem> =
    this.map { resourceItemDto ->
        resourceItemDto.toResourceItem()
    }