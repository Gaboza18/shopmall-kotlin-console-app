package screen

import data.CartItems
import LINE_DIVIDER
import extensions.getNotEmptyString

/*
    장바구니의 내용을 화면에 출력
 */

class ShoppingCart : Screen() {

    private val products = CartItems.products // 장바구니에 담겨있는 상품목록 변수

    fun showCartItems() {

        // 스택에 저장
        ScreenStack.push(this)

        if (products.isNotEmpty()) {
            // 장바구니 상품 목록 출력
            println(
                products.keys.joinToString(
                    separator = ", \n",
                    prefix = """
                            $LINE_DIVIDER
                            
                            장바구니에 담긴 상품 목록입니다.
                            
                        """.trimIndent()
                ) { product ->
                    "카테고리: ${product.categoryLabel} / 상품명: ${product.name} / 수량: ${products[product]}"

                }
            )
        } else {
            println(
                """
                장바구니에 담긴 상품이 없습니다.
            """.trimIndent()
            )
        }
        showPreviousScreenOption()

    }

    /*
        이전 화면으로 돌아가는 기능 구현
     */
    private fun showPreviousScreenOption() {
        println(
            """
            $LINE_DIVIDER
            이전 화면으로 돌아가시겠습니까? (y/n) 
        """.trimIndent()
        )

        when (readLine().getNotEmptyString()) {
            "y" -> {
                // 이전 화면으로 이동
                moveToPreviousScreen()
            }
            "n" -> {
                showCartItems()
            }
            else -> {
                println("잘못 입력하였습니다. 다시 입력해 주세요 (y/n)")
                showPreviousScreenOption()
            }
        }
    }

    private fun moveToPreviousScreen() {

        // (1) 스택에서 현재화면을 popup 시킴
        ScreenStack.pop()

        // (2) 현재 스택에서 제일 위의 클래스를 확인 후 show...() 메소드를 실행
        when (val previousScreen = ScreenStack.peek()) {

            is ShoppingCategory -> {
                previousScreen.ShowCategories() // selectedCategory 필요
            }
            is ShoppingProductList -> {
                previousScreen.showProducts() // selectedCategory 필요
            }
            is ShoppingCart, is ShoppingHome -> {
                // 아무 일도 하지 않음
            }
        }
    }
}