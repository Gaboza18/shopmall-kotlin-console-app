package screen

class ShoppingCategory {

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
            // 입력한 항목이 있으면
            if (categories.contains(selectCategory)) {

            } else { // 입력한 항목이 없으면 에러메세지 출력
                showErrorMessage(selectCategory)
            }
        }
    }

    private fun showErrorMessage(selectCategory: String?) {
        println("[$selectCategory] : 존재하지 않는 카테고리 입니다. 다시 입력해 주세요!")
        ShowCategories()
    }
}