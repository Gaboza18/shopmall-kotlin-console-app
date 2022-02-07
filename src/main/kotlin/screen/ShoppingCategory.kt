package screen

import extensions.getNotEmptyString

class ShoppingCategory : Screen() {

    fun ShowCategories() {

        // 스택에 저장
        ScreenStack.push(this)

        val categories = arrayOf("패션", "전자기기", "반려동물용품")

        for (category in categories) {
            println(category)
        }
        println("=> 장바구니로 이동하시려면 '#'을 입력해 주세요.")

        // 카테고리 입력받기
        // readLine()의 반환타입이 String? 이므로 확장함수 사용 가능
        var selectCategory = readLine().getNotEmptyString()

        // 사용자가 올바른 입력할 때까지 반복처리 -> 위에서 처리하므로 필요 없음
        /*
        while (selectCategory.isNullOrBlank()) { // null 값 또는 "스페이스 공백" 입력시
            println("값을 입력해 주세요.")
            selectCategory = readLine() // 재입력 받는다
        }
        */

        if (selectCategory == "#") {

            // 1. 장바구니로 이동
            val shoppingCart = ShoppingCart()
            shoppingCart.showCartItems()

        } else {
            // 입력한 항목이 있으면
            if (categories.contains(selectCategory)) {
                // 카테고리 상품 목록 보여주기
                val shoppingProductList = ShoppingProductList(selectCategory)
                shoppingProductList.showProducts()
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