package br.com.brunoszczuk.specificationpattern.domain

data class Seller(val name: String)

data class Customer(val name: String, val isNew: Boolean)

data class Product(val name: String, val price: Double, val category: ProductCategory)

data class Order(val customer: Customer, val items: List<OrderItem>, val totalValue: Double, val seller: Seller)

data class OrderItem(val product: Product, val quantity: Int)


enum class ProductCategory {
    ELECTRONICS,
    CLOTHING
}