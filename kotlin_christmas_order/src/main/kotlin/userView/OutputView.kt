package userView

import evnet.BadgeEvent
import evnet.DdayEvent
import evnet.RewardEvent
import evnet.SpecialEvent
import evnet.WeekdayEvent
import evnet.WeekendEvent
import transformation.CalculateInOrder
import transformation.DivideOrder
import transformation.VisitDayOfWeek

class OutputView(day: Int, input: List<String>) {

    private val dDayEvent = DdayEvent(day, input).applyDdayEvent()
    private val dayOfWeeks = VisitDayOfWeek(day).transformDayOfWeek()
    private val weekdayEvent = WeekdayEvent(dayOfWeeks, input).applyWeekdayEvent()
    private val weekendEvent = WeekendEvent(dayOfWeeks, input).applyWeekendEvent()
    private val specialEvent = SpecialEvent(dayOfWeeks).applySpecialEvent()
    private val rewardEvent = RewardEvent(input).applyRewardEvent()

    init{
        println("12월 ${day}일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!")
        println()

        printMenu(input)
        printTotalPrice(input)
        printReward(input)
        printEventDetail(input)
        printTotalDiscount(day,input)
        printFinalPrice(day,input)
        printBadgeEvent(day,input)
    }

    private fun printMenu(input: List<String>) {
        println("<주문 메뉴>")
        val orderNames = DivideOrder(input).getOrderMenuNames()
        val orderAmounts = DivideOrder(input).getOrderMenuAmount()

        for (index in 0 until orderAmounts.size){
            println("${orderNames[index]} ${orderAmounts[index]}개")
        }
        println()
    }

    private fun printEventDetail(input: List<String>) {
        val totalPrice = CalculateInOrder().totalPriceInOrder(input)

        println("<혜택 내역>")
        if(totalPrice >= 10000) {
            printApplyEvent()
        }else{
            println("없음")
        }
        println()
    }

    private fun printApplyEvent() {
        println("크리스마스 디데이 할인: -${dDayEvent}원")
        if(dayOfWeeks == "FRIDAY" || dayOfWeeks == "SATURDAY" ){
            println("주말 할인: -${weekendEvent}원")
        }else{
            println("평일 할인: -${weekdayEvent}원")
        }
        println("특별 할인: -${specialEvent}원")
        println("증정 이벤트: -${rewardEvent}원")
    }

    private fun printTotalPrice(input: List<String>){
        println("<할인 전 총주문 금액>")
        println("${CalculateInOrder().totalPriceInOrder(input)}원")
        println()
    }

    private fun printReward(input: List<String>){
        val rewardEvent = RewardEvent(input).applyRewardEvent()
        println("<증정 메뉴>")
        if (rewardEvent != 0){
            println("샴페인 1개")
        }else{
            println("없음")
        }
        println()
    }

    private fun printTotalDiscount(day: Int, input: List<String>){
        var totalDiscountOrder = CalculateInOrder().totalDiscountInOrder(day,input)

        println("<총혜택 금액>")
        println("-${totalDiscountOrder}원")
        println()
    }

    private fun printFinalPrice(day: Int, input: List<String>){
        val totalPrice = CalculateInOrder().totalPriceInOrder(input)
        val totalDiscount = CalculateInOrder().totalDiscountInOrder(day, input)
        var finalPrice = totalPrice - totalDiscount
        if(rewardEvent > 0) {
            finalPrice = totalPrice - totalDiscount + rewardEvent
        }

        println("<할인 후 예상 결제 금액>")
        println("${finalPrice}원")
        println()
    }

    private fun printBadgeEvent(day: Int, input: List<String>){
        var totalDiscount = CalculateInOrder().totalDiscountInOrder(day, input)
        var badge = BadgeEvent().applyBadgeEvent(totalDiscount)

        println("<12월 이벤트 배지>")
        println(badge)
    }
}