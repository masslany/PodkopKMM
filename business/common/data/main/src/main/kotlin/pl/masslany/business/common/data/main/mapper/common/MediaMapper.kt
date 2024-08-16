package pl.masslany.business.common.data.main.mapper.common

import arrow.core.toOption
import pl.masslany.business.common.data.network.models.common.MediaDto
import pl.masslany.business.common.domain.models.common.Media
import pl.masslany.common.kotlin.mapper.Mapper

interface MediaMapper : Mapper<MediaDto, Media>

class MediaMapperImpl(
    private val embedMapper: EmbedMapper,
    private val photoMapper: PhotoMapper,
    private val surveyMapper: SurveyMapper,
) : MediaMapper {
    override fun map(param: MediaDto): Media {
        return Media(
            embed = param.embed?.let { embedMapper.map(it) }.toOption(),
            photo = param.photo?.let { photoMapper.map(it) }.toOption(),
            survey = param.survey?.let { surveyMapper.map(it) }.toOption(),
        )
    }
}
