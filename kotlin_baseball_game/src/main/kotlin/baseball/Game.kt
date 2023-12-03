package baseball

import Logic.CompareComputerToUser
import camp.nextstep.edu.missionutils.Randoms
import computerNumber.MakeComputerNumber
import input.InputView
import output.OutputView

class Game {
    companion object{
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
        println(computerNumber) //debug
        output.startGame()


            output.printInputUserNumber()
            var userNumber = input.inputUserNumber()
            var compareResult = compare.compareResult(computerNumber,userNumber)
            var strike = compareResult[0]
            var ball = compareResult[1]

            OutputView().printCompareResult(strike, ball)


            if (strike == GAME_END) {
                output.printRestart()
            }
            restart = input.checkToRestart()
        }

    }


}