package validate

import output.ErrorMessage

class InputValidate {
    fun validateInputUserNumber(input: Int) {
        if(input > 999 ||  input < 100)
            throw IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.message)
    }

    fun validateDuplicationUserNumber(input: Int) {
        val user = input.toString()
        for (i in user.indices){
            if(user.indexOf(user[i]) != -1)
                throw IllegalArgumentException(ErrorMessage.DUPLICATION_USER_NUMBER.message)
        }
    }

    fun validateInputRestart(input: Int) {
        if(input != 1 && input != 2)
            throw IllegalArgumentException(ErrorMessage.INVALID_RESTART_NUMBER.message)
    }
}