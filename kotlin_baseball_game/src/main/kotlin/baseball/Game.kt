package baseball

import Logic.CompareComputerToUser
import camp.nextstep.edu.missionutils.Randoms
import computerNumber.MakeComputerNumber
import input.InputView
import output.OutputView

class Game {
    fun start() {
        val output = OutputView()
        val computer = MakeComputerNumber()
        val input = InputView()
        val compare = CompareComputerToUser()

        var restart: Boolean = false

        val winningNumber = computer.makeComputerNumber()
        println(winningNumber) //debug
        output.startGame()


        while (!restart) {
            output.printInputUserNumber()
            var userNumber = input.inputUserNumber()
            var compareResult = compare.compareResult(winningNumber,userNumber)
            var strike = compareResult[0]
            var ball = compareResult[1]

            OutputView().printCompareResult(strike, ball)


            if (strike == 3) {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            }
        }
        restart = checkToRestart()
    }

    private fun checkToRestart(): Boolean {
        var userChoice = "0"
        var restart: Boolean = false

        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요")
        userChoice = readLine()!!

        if (userChoice == "2") {
            restart = true
        } else if (userChoice == "1") {
            restart = false
        }
        return restart
    }
}