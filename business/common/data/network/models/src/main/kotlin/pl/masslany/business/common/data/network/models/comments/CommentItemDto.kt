package pl.masslany.business.common.data.network.models.comments

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import pl.masslany.business.common.data.network.models.DateAsStringSerializer
import pl.masslany.business.common.data.network.models.common.ActionsDto
import pl.masslany.business.common.data.network.models.common.AuthorDto
import pl.masslany.business.common.data.network.models.common.CommentsDto
import pl.masslany.business.common.data.network.models.common.MediaDto
import pl.masslany.business.common.data.network.models.common.VotesDto
import java.util.Date

@Serializable
data class CommentItemDto(
    @SerialName("actions")
    val actions: ActionsDto,
    @SerialName("adult")
    val adult: Boolean,
    @SerialName("archive")
    val archive: Boolean,
    @SerialName("author")
    val author: AuthorDto,
    @SerialName("blacklist")
    val blacklist: Boolean,
    @SerialName("comments")
    val comments: CommentsDto? = null,
    @SerialName("content")
    val content: String,
    @SerialName("created_at")
    @Serializable(with = DateAsStringSerializer::class)
    val createdAt: Date?,
    @SerialName("deletable")
    val deletable: Boolean,
    @SerialName("deleted")
    val deleted: String?,
    @SerialName("device")
    val device: String,
    @SerialName("editable")
    val editable: Boolean,
    @SerialName("favourite")
    val favourite: Boolean,
    @SerialName("id")
    val id: Int,
    @SerialName("media")
    val media: MediaDto,
    @SerialName("parent")
    val parent: ParentDto,
    @SerialName("parent_id")
    val parentId: Int? = null,
    @SerialName("resource")
    val resource: String,
    @SerialName("slug")
    val slug: String,
    @SerialName("tags")
    val tags: List<String>,
    @SerialName("voted")
    val voted: Int,
    @SerialName("votes")
    val votes: VotesDto,
)
