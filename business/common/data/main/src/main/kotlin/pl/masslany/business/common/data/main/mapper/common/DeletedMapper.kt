package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.domain.models.common.Deleted
import pl.masslany.common.kotlin.mapper.Mapper

interface DeletedMapper : Mapper<String?, Deleted>

class DeletedMapperImpl : DeletedMapper {
    override fun map(param: String?): Deleted {
        return when (param) {
            "moderator" -> Deleted.Moderator
            "author" -> Deleted.Author
            else -> Deleted.None
        }
    }
}
