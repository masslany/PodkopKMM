package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.main.mapper.toResource
import pl.masslany.business.common.data.network.models.comments.CommentItemDto
import pl.masslany.business.common.domain.models.common.Comment

fun CommentItemDto.toComment(): Comment =
    Comment(
        actions = actions.toActions(),
        adult = adult,
        archive = archive,
        author = author.toAuthor(),
        comments = null,
        createdAt = createdAt,
        deletable = deletable,
        editable = editable,
        id = id,
        media = media.toMedia(),
        resource = resource.toResource(),
        slug = slug,
        tags = tags,
        voted = voted,
        votes = votes.toVotes(),
        content = content,
        blacklist = blacklist,
        deleted = deleted.toDeleted(),
        device = device,
        favourite = favourite,
        parentId = parentId ?: -1,
    )


fun List<CommentItemDto>.toComments(): List<Comment> =
    this.map { commentItemDto ->
        commentItemDto.toComment()
    }