package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.network.models.entries.SurveyDto
import pl.masslany.business.common.domain.models.common.Survey

fun SurveyDto.toSurvey(): Survey =
    Survey(
        actions = actions.toActions(),
        answers = answers.map { it.toAnswer() },
        count = count,
        deletable = deletable,
        editable = editable,
        question = question,
        voted = voted,
        key = key,
    )
