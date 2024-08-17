package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.network.models.entries.SurveyDto
import pl.masslany.business.common.domain.models.common.Survey
import pl.masslany.common.kotlin.mapper.Mapper

interface SurveyMapper : Mapper<SurveyDto, Survey>

class SurveyMapperImpl(
    private val actionsMapper: ActionsMapper,
    private val answerMapper: AnswerMapper,
) : SurveyMapper {
    override fun map(param: SurveyDto): Survey {
        return Survey(
            actions = actionsMapper.map(param.actions),
            answers = param.answers.map { answerMapper.map(it) },
            count = param.count,
            deletable = param.deletable,
            editable = param.editable,
            key = param.key,
            question = param.question,
            voted = param.voted,
        )
    }
}
