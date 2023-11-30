package userView

import camp.nextstep.edu.missionutils.Console
import validate.InputValidate

class InputView {

    val check = InputValidate()

    fun readDate(): Int {
        var input = 0
        while (true) {
            println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")
            println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)")
            try {
                input = Console.readLine().toInt()
                check.validateOfVisitDay(input)
                break
            } catch (e: NumberFormatException) {
                println(ErrorMessage.INVALID_DATE_MESSAGE.message)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        return input
    }

    fun readMenu(): List<String> {
        var orderMenus = listOf<String>()

        while (true) {
            println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)")
            val input = Console.readLine()
            orderMenus = input.split(",")
            try {
                check.validateOfMenuName(orderMenus)
                break
            }catch (e: IllegalArgumentException){
                println(e.message)
            }
        }
        return orderMenus
    }
}