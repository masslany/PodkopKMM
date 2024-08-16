package pl.masslany.business.common.data.main.mapper

import pl.masslany.business.common.domain.models.common.Gender
import pl.masslany.common.kotlin.mapper.Mapper

interface GenderMapper : Mapper<String?, Gender>

class GenderMapperImpl : GenderMapper {
    override fun map(param: String?): Gender {
        return when (param) {
            "m" -> Gender.Male
            "f" -> Gender.Female
            else -> Gender.Unspecified
        }
    }
}
