package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.network.models.entries.AnswerDto
import pl.masslany.business.common.domain.models.common.Answer
import pl.masslany.common.kotlin.mapper.Mapper

interface AnswerMapper : Mapper<AnswerDto, Answer>

class AnswerMapperImpl : AnswerMapper {
    override fun map(param: AnswerDto): Answer {
        return Answer(
            count = param.count,
            id = param.id,
            text = param.text,
            voted = param.voted,
        )
    }
}
