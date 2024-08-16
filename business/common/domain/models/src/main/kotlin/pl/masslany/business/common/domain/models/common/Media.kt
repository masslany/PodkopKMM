package pl.masslany.business.common.domain.models.common

import arrow.core.Option

data class Media(
    val embed: Option<Embed>,
    val photo: Option<Photo>,
    val survey: Option<Survey>,
)
