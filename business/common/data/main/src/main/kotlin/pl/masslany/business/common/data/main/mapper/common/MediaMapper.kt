package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.network.models.common.MediaDto
import pl.masslany.business.common.domain.models.common.Media

fun MediaDto.toMedia(): Media =
    Media(
        embed = embed?.toEmbed(),
        photo = photo?.toPhoto(),
        survey = survey?.toSurvey(),
    )
