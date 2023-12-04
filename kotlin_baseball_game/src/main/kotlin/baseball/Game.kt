package baseball

import Logic.CompareComputerToUser
import computerNumber.MakeComputerNumber
import input.InputView
import output.OutputView

class Game {
    companion object {
        const val GAME_END = 3
    }

    fun start() {
        val output = OutputView()
        val computer = MakeComputerNumber()
        val input = InputView()
        val compare = CompareComputerToUser()
        var restart = false


        while (!restart) {
            val computerNumber = computer.makeComputerNumber()
            println(computerNumber)
            output.printStartGame()

            while (true) {
                output.printInputUserNumber()
                val userNumber = input.inputUserNumber()
                val compareResult = compare.compareResult(computerNumber, userNumber)
                val strike = compareResult[0]
                val ball = compareResult[1]

                output.printCompareResult(strike, ball)


                if (strike == GAME_END) {
                    output.printRestart()
                    break
                }
            }
            restart = input.checkToRestart()
        }

    }


}