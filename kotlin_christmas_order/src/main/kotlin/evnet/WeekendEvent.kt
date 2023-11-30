package evnet

import transformation.ConversionByName
import transformation.DivideOrder

class WeekendEvent (day: String, input: List<String>) {
    companion object{
        val weekends = listOf("FRIDAY", "SATURDAY")
    }

    private var onTarget = false
    private var discount = 0
    private var totalMainAmount = 0

    init {
        if(weekends.contains(day) && amountOfMainInOrder(input) != 0){
            onTarget = true
        }
    }

    fun applyWeekendEvent() : Int{
        if(onTarget) {
            discount += 2023 * totalMainAmount
        }
        return discount
    }

    private fun amountOfMainInOrder(input: List<String>) :Int{
        val orderMenuNames = DivideOrder(input).getOrderMenuNames()
        val orderMenuCategorys = ConversionByName().nameToCategory(orderMenuNames)
        val indexs = mutableListOf<Int>()


        for(index in 0 until orderMenuCategorys.size){
            if (orderMenuCategorys[index] == "MAIN") indexs.add(index)
        }

        totalMainAmount = searchMainInCategory(input, indexs)

        return totalMainAmount
    }

    private fun searchMainInCategory(input: List<String>, indexs: MutableList<Int>) : Int{
        val orderMenuAmounts = DivideOrder(input).getOrderMenuAmount()
        var totalMainAmount = 0

        for(index in indexs) {
            totalMainAmount += orderMenuAmounts[index]
        }
        return totalMainAmount
    }
}