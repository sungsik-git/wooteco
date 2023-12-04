package input

import camp.nextstep.edu.missionutils.Console
import validate.InputValidate

class InputView {
    companion object{
        const val GAME_FINISH_BUTTON = 2
    }
    private val validate = InputValidate()
    fun inputUserNumber() : Int{
        val user = Console.readLine().toInt()
        validate.validateInputUserNumber(user)
        validate.validateDuplicationUserNumber(user)
        return user
    }

    fun checkToRestart(): Boolean{
        val input = Console.readLine().toInt()
        validate.validateInputRestart(input)

        return input == GAME_FINISH_BUTTON
    }
}