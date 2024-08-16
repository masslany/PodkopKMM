package pl.masslany.business.common.domain.models.common

import arrow.core.Option
import java.util.Date

data class ResourceItem(
    val actions: Option<Actions>,
    val adult: Boolean,
    val archive: Boolean,
    val author: Option<Author>,
    val comments: Option<Comments>,
    val content: String,
    val createdAt: Option<Date>,
    val deleted: Deleted,
    val deletable: Boolean,
    val description: String,
    val editable: Boolean,
    val hot: Boolean,
    val id: Int,
    val media: Option<Media>,
    val name: String,
    val publishedAt: Option<Date>,
    val recommended: Boolean,
    val resource: Resource,
    val slug: String,
    val source: Option<Source>,
    val tags: List<String>,
    val title: String,
    val voted: Boolean,
    val votes: Option<Votes>,
)
