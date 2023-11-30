package evnet

import transformation.CalculateInOrder

class RewardEvent (orderMenus: List<String>) {
    companion object{
        const val MINIMUM_EVENT_PRICE = 120000
        const val CHAMPAGNE_PRICE = 25000
    }

    private var onTarget = false
    private var totalPrice = CalculateInOrder().totalPriceInOrder(orderMenus)

    init {
        if(totalPrice > MINIMUM_EVENT_PRICE) onTarget = true
    }

    fun applyRewardEvent() : Int{
        var discount = 0

        if(onTarget){
            discount += CHAMPAGNE_PRICE
        }
        return discount
    }

}