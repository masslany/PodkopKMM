package pl.masslany.business.common.data.main.mapper

import pl.masslany.business.common.domain.models.common.NameColor
import pl.masslany.common.kotlin.mapper.Mapper

interface NameColorMapper : Mapper<String, NameColor>

class NameColorMapperImpl : NameColorMapper {
    override fun map(param: String): NameColor {
        return when (param) {
            "orange" -> NameColor.Orange
            "burgundy" -> NameColor.Burgundy
            "green" -> NameColor.Green
            "black" -> NameColor.Black
            else -> NameColor.Orange
        }
    }
}
