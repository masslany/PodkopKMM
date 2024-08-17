package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.network.models.common.ResourceResponseDto
import pl.masslany.business.common.domain.models.common.Resources


fun ResourceResponseDto.toResources(): Resources =
    Resources(
        data = data.toResourceItems(),
        pagination = pagination?.toPagination(),
    )
