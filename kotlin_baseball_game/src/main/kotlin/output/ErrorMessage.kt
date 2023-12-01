package output

enum class ErrorMessage (
    var message: String
){
    INVALID_NUMBER_RANGE("[ERROR] 숫자는 100부터 999사이의 숫자만 입력 가능합니다."),
}