package pl.masslany.business.common.domain.models.common

import arrow.core.Option

data class Resources(
    val data: List<ResourceItem>,
    val pagination: Option<Pagination>,
)
