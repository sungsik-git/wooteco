package evnet

class SpecialEvent(day: String) {
    companion object {
        const val DISCOUNT_AMOUNT = 1000

    }
    private val specialDay = listOf("SUNDAY", "CHRISTMAS")
    private var onTarget = false

    init {
        if (specialDay.contains(day)) onTarget = true
    }

    fun applySpecialEvent(): Int {
        var discount = 0
        if (onTarget) {
            discount = DISCOUNT_AMOUNT
        }
        return discount
    }
}