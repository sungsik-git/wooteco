package output

enum class ErrorMessage (
    var message: String
){
    INVALID_NUMBER_RANGE("[ERROR] 3자리의 숫자까지만 입력 가능합니다."),
    START_NUMBER_ZERO("[ERROR] 시작하는 숫자는 0이 될 수 없습니다."),
    INPUT_NOT_INTEGER("[ERROR] 숫자 이외의 값은 입력될 수 없습니다."),
    INVALID_RESTART_CHOICE("[ERROR] 1과 2 외의 값은 입력될 수 없습니다.")
}