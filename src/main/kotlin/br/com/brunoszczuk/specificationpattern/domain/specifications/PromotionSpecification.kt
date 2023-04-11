package br.com.brunoszczuk.specificationpattern.domain.specifications

import br.com.brunoszczuk.specificationpattern.domain.Order
import br.com.brunoszczuk.specificationpattern.domain.ProductCategory
import br.com.brunoszczuk.specificationpattern.domain.design.CompositeSpecification
import org.springframework.stereotype.Component


@Component
class NewClientForPromotionSpecification : CompositeSpecification<Order>() {
    override fun isSatisfiedBy(candidate: Order): Boolean {
        return candidate.customer.isNew
    }
}

@Component
class ElectronicProductForPromotionSpecification : CompositeSpecification<Order>() {
    override fun isSatisfiedBy(candidate: Order): Boolean {
        return candidate.items.any { it.product.category == ProductCategory.ELECTRONICS }
    }
}


@Component
class SeniorSellerForPromotionSpecification : CompositeSpecification<Order>() {
    override fun isSatisfiedBy(candidate: Order): Boolean {
        return candidate.seller.name.startsWith("S")
    }
}

@Component
class JuniorSellerForPromotionSpecification : CompositeSpecification<Order>() {
    override fun isSatisfiedBy(candidate: Order): Boolean {
        return candidate.seller.name.startsWith("J")
    }
}