package order

import userView.InputView
import userView.OutputView

class UserOrder {
    private var inputView = InputView()
    fun start(){
        var visitDay = inputView.readDate()
        var orderMenus = inputView.readMenu()

        OutputView(visitDay,orderMenus)
    }
}