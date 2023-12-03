package input

import camp.nextstep.edu.missionutils.Console
import validate.InputValidate

class InputView {
    fun inputUserNumber() : Int{
        val validate = InputValidate()
        val user = Console.readLine().toInt()
        validate.validateInputUserNumber(user)
        return user
    }

    fun checkToRestart(): Boolean = readln().let { return it == "2" }
}