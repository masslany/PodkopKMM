package pl.masslany.network.api

import kotlinx.coroutines.flow.Flow
import pl.masslany.network.models.refresh.RefreshAction
import pl.masslany.network.models.refresh.RefreshState

interface RefreshTokensEventReducer {
    val state: Flow<RefreshState>

    suspend fun reduce(action: RefreshAction)
}
