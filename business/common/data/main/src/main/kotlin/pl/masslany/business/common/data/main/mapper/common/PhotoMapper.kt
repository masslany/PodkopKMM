package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.network.models.common.PhotoDto
import pl.masslany.business.common.domain.models.common.Photo
import pl.masslany.common.kotlin.mapper.Mapper

interface PhotoMapper : Mapper<PhotoDto, Photo>

class PhotoMapperImpl : PhotoMapper {
    override fun map(param: PhotoDto): Photo {
        return Photo(
            height = param.height,
            key = param.key,
            label = param.label,
            mimeType = param.mimeType,
            size = param.size,
            url = param.url,
            width = param.width,
        )
    }
}
