package transformation

import userView.ErrorMessage

class DivideOrder (private val input: List<String>) {

    fun getOrderMenuNames(): List<String>{
        return input.map { it.split("-").first() }
    }

    fun getOrderMenuAmount(): List<Int> {
        return input.map {
            try {
                it.split("-").last().toInt()
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException(ErrorMessage.INVALID_ORDER_MESSAGE.message, e)
            }
        }
    }


}