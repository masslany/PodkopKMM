package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.main.mapper.toGender
import pl.masslany.business.common.data.main.mapper.toNameColor
import pl.masslany.business.common.data.network.models.common.AuthorDto
import pl.masslany.business.common.domain.models.common.Author

fun AuthorDto.toAuthor(): Author =
    Author(
        avatar = avatar,
        blacklist = blacklist,
        color = color.toNameColor(),
        company = company,
        follow = follow,
        gender = gender.toGender(),
        note = note,
        online = online,
        rank = rank.toRank(),
        status = status,
        username = username,
        verified = verified,
    )
