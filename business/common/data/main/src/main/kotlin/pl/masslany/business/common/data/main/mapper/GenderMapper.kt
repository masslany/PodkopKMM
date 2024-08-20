package pl.masslany.business.common.data.main.mapper

import pl.masslany.business.common.domain.models.common.Gender

fun String?.toGender(): Gender {
    return when (this) {
        "m" -> Gender.Male
        "f" -> Gender.Female
        else -> Gender.Unspecified
    }
}
