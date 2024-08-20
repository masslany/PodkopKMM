package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.domain.models.common.Deleted

fun String?.toDeleted(): Deleted {
    return when (this) {
        "moderator" -> Deleted.Moderator
        "author" -> Deleted.Author
        else -> Deleted.None
    }
}
