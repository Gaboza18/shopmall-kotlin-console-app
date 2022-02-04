package data

/*
    상품 데이터를 저장
    - 프로젝트 전역에서 참조하는 데이터 유지
 */

object CartItems {

    private val mutableProducts = mutableMapOf<Product, Int>()

    val products: Map<Product, Int> = CartItems.mutableProducts

    fun addProduct(product: Product) {

        mutableProducts[product]?.let { // null이 아닌경우 실행 : let
            mutableProducts[product] = it + 1 // null이 아니면
        } ?: kotlin.run {
            mutableProducts[product] = 1 // null 이면
        }
    }

}