package screen

class ShoppingHome {

    /*
        쇼핑몰 프로그램의 시작 위치
     */

    fun start() {

        ShowWelcomeMessage() // 인사말 출력

        ShowCategories() // 카테고리 선택창 출력
    }

    // (1) 인사말 출력
    fun ShowWelcomeMessage() {

        println("안녕하세요 Shopingmall 에 오신 것을 환영합니다.")
        println("쇼핑을 계속 하시려면 이름을 입력해 주세요:")

        val name = readLine() // 화면에서 사용자 입력받기

        // println문 안에 내용 그대로 출력 println(""" 입력할 내용 """".trimIndent())
        println(
            """
            ------------------------------
            
            감사합니다. 반갑습니다. $name 님
            원하시는 카테고리를 입력해주세요.
            
            ------------------------------ 
        """.trimIndent()
        )
    }

    // (2) 카테고리 입력
    fun ShowCategories() {
        val categories = arrayOf("패션", "전자기기", "반려동물용품")

        for (category in categories) {
            println(category)
        }
        println("=> 장바구니로 이동하시려면 '#'을 입력해 주세요.")

        var selectCategory = readLine()

        // 사용자가 올바른 입력할 때까지 반복처리

        while (selectCategory.isNullOrBlank()) { // null 값 또는 "스페이스 공백" 입력시
            println("값을 입력해 주세요.")
            selectCategory = readLine() // 재입력 받는다
        }

        if (selectCategory == "#") {

            // 1. 장바구니로 이동

        } else {
            // 2. 카테고리 상품 목록 보여주기
            // 3. 카테고리 목록에 없는 경우 처리
        }
    }


}