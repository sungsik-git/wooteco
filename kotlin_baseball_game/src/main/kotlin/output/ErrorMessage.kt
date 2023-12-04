package output

enum class ErrorMessage (
    var message: String
){
    INVALID_NUMBER_RANGE("[ERROR] 숫자는 100부터 999사이의 숫자만 입력 가능합니다."),
    INVALID_RESTART_NUMBER("[ERROR]1 또는 2의  숫자를 입력해야합니다.")
}