package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.network.models.entries.AnswerDto
import pl.masslany.business.common.domain.models.common.Answer

fun AnswerDto.toAnswer(): Answer {
    return Answer(
        count = count,
        id = id,
        text = text,
        voted = voted,
    )
}