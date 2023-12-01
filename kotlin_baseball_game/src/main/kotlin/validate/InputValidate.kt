package validate

import output.ErrorMessage

class InputValidate {
    fun validateInputUserNumber(input: Int) {
        if(input > 999 ||  input < 100)
            throw IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.message)
    }
}