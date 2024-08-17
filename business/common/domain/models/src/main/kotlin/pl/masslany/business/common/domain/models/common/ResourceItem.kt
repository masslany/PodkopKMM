package pl.masslany.business.common.domain.models.common

import java.util.Date

data class ResourceItem(
    val actions: Actions?,
    val adult: Boolean,
    val archive: Boolean,
    val author: Author?,
    val comments: Comments?,
    val content: String,
    val createdAt: Date,
    val deleted: Deleted,
    val deletable: Boolean,
    val description: String,
    val editable: Boolean,
    val hot: Boolean,
    val id: Int,
    val media: Media,
    val name: String,
    val publishedAt: Date,
    val recommended: Boolean,
    val resource: Resource,
    val slug: String,
    val source: Source,
    val tags: List<String>,
    val title: String,
    val voted: Boolean,
    val votes: Votes,
)
