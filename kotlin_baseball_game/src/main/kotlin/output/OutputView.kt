package output

class OutputView {
    fun startGame(){
        println("숫자 야구 게임을 시작합니다.")
    }

    fun printInputUserNumber(){
        print("숫자를 입력해주세요 : ")
    }

    fun printCompareResult(strike: Int, ball: Int){
        if (strike == 0 && ball == 0) {
            println("낫싱")
        } else if (strike == 0 && ball != 0) {
            println("${ball}볼")
        } else if (strike != 0 && ball == 0) {
            println("${strike}스트라이크")
        } else {
            println("${ball}볼 ${strike}스트라이크")
        }
    }
}