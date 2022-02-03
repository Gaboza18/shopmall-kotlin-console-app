package screen

import data.Product


class ShoppingProductList {

    private val products = arrayOf(
        Product("패션", "겨울패딩"),
        Product("패션", "겨울바지"),
        Product("전자기기", "핸드폰"),
        Product("전자기기", "블루투스 이어폰"),
        Product("전자기기", "노트북"),
        Product("반려동물용품", "건식사료"),
        Product("반려동물용품", "습식사료"),
        Product("반려동물용품", "치약"),
        Product("반려동물용품", "간식"),
    )

    /*
        카테고리별 상품목록 변수 저장

        패션 - ("패션","겨울패딩"),("패션","겨울바지")
        전자기기 - ("전자기기","핸드폰"),("전자기기","블루투스 이어폰")
     */
    private val categories: Map<String, List<Product>> =
        products.groupBy { products ->
            products.categoryLabel
        }

    /*
        사용자가 입력한 카테고리 정보를 받아 해당 카테고리의 상품을 출력하는 함수
     */
    fun showProducts(selectedCategory: String) {

        // 지정된 카테고리의 상품목록을 가져온다.
        val categoryProducts = categories[selectedCategory] // 키: selectedCategory

        // 가져온 상품목록이 비어있지 않으면
        if (!categoryProducts.isNullOrEmpty()) {
            println(
                """
                ------------------------------
                
                선택하신 [$selectedCategory] 카테고리 상품입니다.
                
                ------------------------------
            """.trimIndent()
            )

            val productsize = categoryProducts.size // 각 카테고리의 size를 담는 변수

            for (index in 0 until productsize) {
                println("${index}.${categoryProducts[index].name}")
            }
        } else {
            showEmptyProductMessage(selectedCategory)
        }
    }

    private fun showEmptyProductMessage(selectedCategory: String) {
        println("[$selectedCategory] 카테고리 상품이 등록되기 전입니다.")
    }
}