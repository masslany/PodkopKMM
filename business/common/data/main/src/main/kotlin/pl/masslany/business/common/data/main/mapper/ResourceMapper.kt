package pl.masslany.business.common.data.main.mapper

import pl.masslany.business.common.domain.models.common.Resource
import pl.masslany.common.kotlin.mapper.Mapper

interface ResourceMapper : Mapper<String?, Resource>

class ResourceMapperImpl : ResourceMapper {
    override fun map(param: String?): Resource {
        return when (param) {
            "link" -> Resource.Link
            "entry" -> Resource.Entry
            "entry_comment" -> Resource.EntryComment
            "link_comment" -> Resource.LinkComment
            else -> Resource.Unknown
        }
    }
}
