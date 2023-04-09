package br.com.brunoszczuk.specificationpattern.domain.specifications

import br.com.brunoszczuk.specificationpattern.domain.Order
import br.com.brunoszczuk.specificationpattern.domain.ProductCategory
import br.com.brunoszczuk.specificationpattern.domain.design.CompositeSpecification
import org.springframework.stereotype.Component

abstract class PromotionSpecification : CompositeSpecification<Order>()

@Component
class NewClientForPromotionSpecification : PromotionSpecification() {
    override fun isSatisfiedBy(candidate: Order): Boolean {
        return candidate.customer.isNew
    }
}

@Component
class ElectronicProductForPromotionSpecification : PromotionSpecification() {
    override fun isSatisfiedBy(candidate: Order): Boolean {
        return candidate.items.any { it.product.category == ProductCategory.ELECTRONICS }
    }
}

@Component
class SeniorSellerForPromotionSpecification : PromotionSpecification() {
    override fun isSatisfiedBy(candidate: Order): Boolean {
        return candidate.seller.name.startsWith("S")
    }
}

@Component
class JuniorSellerForPromotionSpecification : PromotionSpecification() {
    override fun isSatisfiedBy(candidate: Order): Boolean {
        return candidate.seller.name.startsWith("J")
    }
}