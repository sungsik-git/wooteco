package Logic

class CompareComputerToUser {
    fun compareResult(computer: MutableList<Int>, input: Int): MutableList<Int> {
        val userNumber = changIntToList(input)
        return compareComputerToUser(computer,userNumber)
    }

    private fun changIntToList(input: Int) : MutableList<Int>{
        var inputDigits = input
        val individualDigits = mutableListOf<Int>()

        while (inputDigits > 0) {
            individualDigits.add(0, inputDigits % 10)
            inputDigits /= 10
        }

        return individualDigits
    }

    private fun compareComputerToUser(computer: MutableList<Int>, userNumber: MutableList<Int>) : MutableList<Int>{
        var strike = 0
        var ball = 0

        for (i in userNumber.indices) {
            for (j in computer.indices) {
                if (userNumber[i] == computer[j]) {
                    if (i == j) strike++
                    else ball++
                }
            }
        }
        return mutableListOf(strike, ball)
    }
}