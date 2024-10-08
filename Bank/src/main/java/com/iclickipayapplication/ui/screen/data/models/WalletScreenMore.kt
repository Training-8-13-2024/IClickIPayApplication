package com.iclickipayapplication.ui.screen.data.models

sealed class WalletScreenMore(){
    object DEFAULT_SCREEN: WalletScreenMore()
    data class MORE_INFO(val transaction: Dummy): WalletScreenMore()
}
