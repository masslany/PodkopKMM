package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.network.models.common.PhotoDto
import pl.masslany.business.common.domain.models.common.Photo

fun PhotoDto.toPhoto(): Photo {
    return Photo(
        height = height,
        key = key,
        label = label,
        mimeType = mimeType,
        size = size,
        width = width,
        url = url,
    )
}
