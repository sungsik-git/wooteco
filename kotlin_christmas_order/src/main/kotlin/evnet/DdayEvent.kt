package evnet

import transformation.CalculateInOrder

class DdayEvent(private val visitDay: Int, input: List<String>) {
    companion object {
        const val DEFAULT_DISCOUNT: Int = 1000
        const val DAILY_ADDITIONAL_DISCOUNT: Int = 100
        const val MINIMUM_ORDER_PRICE = 10000
    }

    private var onTarget = false
    private var discount = 0
    private var totalPrice = CalculateInOrder().totalPriceInOrder(input)

        init {
            if (visitDay in 1..25 && totalPrice > MINIMUM_ORDER_PRICE) onTarget = true
        }

    fun applyDdayEvent(): Int {
        if (onTarget) {
            discount += DEFAULT_DISCOUNT + ((visitDay - 1) * DAILY_ADDITIONAL_DISCOUNT)
        }
        return discount
    }
}