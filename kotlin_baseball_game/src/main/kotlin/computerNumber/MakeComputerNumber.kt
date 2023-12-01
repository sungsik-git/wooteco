package computerNumber

import camp.nextstep.edu.missionutils.Randoms

class MakeComputerNumber {
    companion object{
        private const val SIZE_OF_COMPUTER_NUMBER = 3
        private const val MINIMUM_VALUE_OF_RANDOM_NUMBER = 1
        private const val MAXIMUM_VALUE_OF_RANDOM_NUMBER = 9
    }

    fun makeComputerNumber() : MutableList<Int> {
        val computerNumber = mutableListOf<Int>()
        while (computerNumber.size < SIZE_OF_COMPUTER_NUMBER) {
            val randomNumber = Randoms.pickNumberInRange(
                MINIMUM_VALUE_OF_RANDOM_NUMBER,
                MAXIMUM_VALUE_OF_RANDOM_NUMBER)
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber)
            }
        }
        return computerNumber
    }
}