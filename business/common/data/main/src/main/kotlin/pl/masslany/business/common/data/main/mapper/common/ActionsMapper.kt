package pl.masslany.business.common.data.main.mapper.common

import pl.masslany.business.common.data.network.models.common.ActionsDto
import pl.masslany.business.common.domain.models.common.Actions
import pl.masslany.common.kotlin.mapper.Mapper

interface ActionsMapper : Mapper<ActionsDto, Actions>

class ActionsMapperImpl : ActionsMapper {
    override fun map(param: ActionsDto): Actions {
        return Actions(
            create = param.create ?: false,
            createFavourite = param.createFavourite ?: false,
            delete = param.delete ?: false,
            deleteFavourite = param.deleteFavourite ?: false,
            finishAma = param.finishAma ?: false,
            report = param.report ?: false,
            startAma = param.startAma ?: false,
            undoVote = param.undoVote ?: false,
            update = param.update ?: false,
            voteDown = param.voteDown ?: false,
            voteUp = param.voteUp ?: false,
        )
    }
}
