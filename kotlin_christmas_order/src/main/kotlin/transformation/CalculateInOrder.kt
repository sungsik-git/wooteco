package transformation

import evnet.DdayEvent
import evnet.RewardEvent
import evnet.SpecialEvent
import evnet.WeekdayEvent
import evnet.WeekendEvent

class CalculateInOrder {
    fun totalPriceInOrder(input: List<String>) : Int{
        val orderMenuAmount = DivideOrder(input).getOrderMenuAmount()
        val orderMenuNames = DivideOrder(input).getOrderMenuNames()
        val orderMenuPrices = ConversionByName().nameToPrice(orderMenuNames)
        var totalPrice = 0
        for (index in 0 until orderMenuPrices.size){
            totalPrice += orderMenuAmount[index] * orderMenuPrices[index]
        }
        return totalPrice
    }

    fun totalDiscountInOrder(day: Int, input: List<String>): Int {
        val dDayEvent = DdayEvent(day, input).applyDdayEvent()
        val dayOfWeeks = VisitDayOfWeek(day).transformDayOfWeek()
        val weekdayEvent = WeekdayEvent(dayOfWeeks, input).applyWeekdayEvent()
        val weekendEvent = WeekendEvent(dayOfWeeks, input).applyWeekendEvent()
        val specialEvent = SpecialEvent(dayOfWeeks).applySpecialEvent()
        val rewardEvent = RewardEvent(input).applyRewardEvent()
        return dDayEvent + weekdayEvent + weekendEvent + specialEvent + rewardEvent
    }
}