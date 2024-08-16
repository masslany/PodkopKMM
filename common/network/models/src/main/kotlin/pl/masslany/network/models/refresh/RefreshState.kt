package pl.masslany.network.models.refresh

sealed class RefreshState {
    data object Refreshed : RefreshState()

    data object None : RefreshState()
}
