package pl.masslany.business.common.data.main.mapper

import pl.masslany.business.common.domain.models.common.Resource

fun String?.toResource(): Resource {
    return when (this) {
        "link" -> Resource.Link
        "entry" -> Resource.Entry
        "entry_comment" -> Resource.EntryComment
        "link_comment" -> Resource.LinkComment
        else -> Resource.Unknown
    }
}
