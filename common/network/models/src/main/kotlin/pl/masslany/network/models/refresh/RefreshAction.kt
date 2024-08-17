package pl.masslany.network.models.refresh

sealed class RefreshAction {
    data object Refresh : RefreshAction()

    data object Reset : RefreshAction()
}
