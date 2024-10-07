package iclickipay.doctor.ui.constants

sealed class InnerNav(val route: String) {
    object Symptoms : InnerNav("Symptoms")
    object Results : InnerNav("Results")
    object Summary : InnerNav("Summary")
}