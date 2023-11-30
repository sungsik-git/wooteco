package validate

import transformation.CalculateInOrder
import transformation.ConversionByName
import transformation.DivideOrder
import userView.ErrorMessage
import userView.MenuName

class InputValidate {
    companion object{
        const val MAX_VOLUME_ONE_ORDER = 20
        const val NONE_ORDER_VOLUME = 1
        const val FIRST_DAY_OF_DECEMBER = 1
        const val LAST_DAY_OF_DECEMBER = 31
    }

    fun validateOfVisitDay(input: Int) {
        checkVisitDayRange(input)
    }

    fun validateOfMenuName(input: List<String>) {
        checkOrderMenuInMenuName(input)
        checkOrderMenuCount(input)
        checkSameMenuName(input)
        checkOrderMenuFormat(input)
        checkOrderCategoryOnlyDrink(input)
        checkOrderAmountUnder20(input)
    }

    private fun checkVisitDayRange(input: Int) {
        if (input < FIRST_DAY_OF_DECEMBER || input > LAST_DAY_OF_DECEMBER)
            throw IllegalArgumentException(ErrorMessage.INVALID_DATE_MESSAGE.message)
    }

    private fun checkOrderMenuInMenuName(input: List<String>) {
        val orderMenuNames = DivideOrder(input).getOrderMenuNames()
        val menuNames = MenuName.values().map { it.menuName }
        var checkMenuName = true

        for (orderMenuName in orderMenuNames) {
            checkMenuName = menuNames.contains(orderMenuName)
        }

        if (!checkMenuName)
            throw IllegalArgumentException(ErrorMessage.INVALID_ORDER_MESSAGE.message)
    }

    private fun checkOrderMenuFormat(input: List<String>) {
        if (input.all { !it.contains("-") })
            throw IllegalArgumentException(ErrorMessage.INVALID_ORDER_MESSAGE.message)
    }

    private fun checkSameMenuName(input: List<String>) {
        val orderMenuNames = DivideOrder(input).getOrderMenuNames()
        val removeSameOrderMenuName = orderMenuNames.distinct()

        if (orderMenuNames.size != removeSameOrderMenuName.size)
            throw IllegalArgumentException(ErrorMessage.INVALID_ORDER_MESSAGE.message)
    }

    private fun checkOrderMenuCount(input: List<String>) {
        val orderMenuAmounts = DivideOrder(input).getOrderMenuAmount()

        for (orderMenuAmount in orderMenuAmounts) {
            if (orderMenuAmount < NONE_ORDER_VOLUME)
                throw IllegalArgumentException(ErrorMessage.INVALID_ORDER_MESSAGE.message)
        }
    }

    private fun checkOrderCategoryOnlyDrink(input: List<String>) {
        var orderMenuNames = DivideOrder(input).getOrderMenuNames()
        var orderCategorys = ConversionByName().nameToCategory(orderMenuNames)

        if(orderCategorys.all { it == "DRINK" })
            throw IllegalArgumentException(ErrorMessage.INVALID_ORDER_MESSAGE.message)
    }

    private fun checkOrderAmountUnder20(input: List<String>){
        val orderMenuAmounts = DivideOrder(input).getOrderMenuAmount()
        var totalAmount = 0

        for (orderMenuAmount in orderMenuAmounts){
            totalAmount += orderMenuAmount
        }

        if (totalAmount > MAX_VOLUME_ONE_ORDER)
            throw IllegalArgumentException(ErrorMessage.INVALID_ORDER_MESSAGE.message)
    }
}