package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.network.models.common.ActionsDto
import pl.masslany.business.common.domain.models.common.Actions

fun ActionsDto.toActions(): Actions {
    return Actions(
        create = create ?: false,
        createFavourite = createFavourite ?: false,
        delete = delete ?: false,
        deleteFavourite = deleteFavourite ?: false,
        finishAma = finishAma ?: false,
        report = report ?: false,
        startAma = startAma ?: false,
        undoVote = undoVote ?: false,
        update = update ?: false,
        voteDown = voteDown ?: false,
        voteUp = voteUp ?: false,
    )
}
