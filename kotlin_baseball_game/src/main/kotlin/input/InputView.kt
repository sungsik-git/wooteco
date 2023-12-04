package input

import camp.nextstep.edu.missionutils.Console
import validate.InputValidate

class InputView {
    val validate = InputValidate()
    fun inputUserNumber() : Int{
        val user = Console.readLine().toInt()
        validate.validateInputUserNumber(user)
        return user
    }

    fun checkToRestart(): Boolean{
        val input = Console.readLine().toInt()
        validate.validateInputRestart(input)

        return return input == 2
    }
}