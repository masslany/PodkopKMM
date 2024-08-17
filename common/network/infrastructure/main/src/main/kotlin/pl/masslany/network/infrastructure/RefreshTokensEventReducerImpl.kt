package pl.masslany.network.infrastructure

import kotlinx.coroutines.flow.MutableStateFlow
import pl.masslany.network.api.RefreshTokensEventReducer
import pl.masslany.network.models.refresh.RefreshAction
import pl.masslany.network.models.refresh.RefreshState

class RefreshTokensEventReducerImpl : RefreshTokensEventReducer {
    override val state = MutableStateFlow<RefreshState>(RefreshState.None)

    override suspend fun reduce(action: RefreshAction) {
        state.value =
            when (action) {
                RefreshAction.Refresh -> RefreshState.Refreshed
                RefreshAction.Reset -> RefreshState.None
            }
    }
}
