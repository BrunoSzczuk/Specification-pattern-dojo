package br.com.brunoszczuk.specificationpattern.domain.rule

import br.com.brunoszczuk.specificationpattern.domain.Order
import br.com.brunoszczuk.specificationpattern.domain.design.Specification
import br.com.brunoszczuk.specificationpattern.domain.service.RuleToggleService
import br.com.brunoszczuk.specificationpattern.domain.specifications.ElectronicProductForPromotionSpecification
import br.com.brunoszczuk.specificationpattern.domain.specifications.JuniorSellerForPromotionSpecification
import br.com.brunoszczuk.specificationpattern.domain.specifications.NewClientForPromotionSpecification
import br.com.brunoszczuk.specificationpattern.domain.specifications.SeniorSellerForPromotionSpecification
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.math.BigDecimal


val ELECTRONIC_PRODUCT_DISCOUNT: BigDecimal = BigDecimal.valueOf(0.05)
val JUNIOR_SELLER_DISCOUNT: BigDecimal = BigDecimal.valueOf(0.05)
val NEW_CLIENT_DISCOUNT: BigDecimal = BigDecimal.valueOf(0.1)
val SENIOR_SELLER_DISCOUNT: BigDecimal = BigDecimal.valueOf(0.15)


open class PromotionRule(val specification: Specification<Order>, val discount: BigDecimal) {
    @Autowired
    lateinit var ruleToggleService: RuleToggleService
    val active: Boolean get() = ruleToggleService.isRuleActive(this.javaClass.simpleName)
}

@Component
class NewClientPromotionRule(newClientForPromotionSpecification: NewClientForPromotionSpecification) :
    PromotionRule(newClientForPromotionSpecification, NEW_CLIENT_DISCOUNT)

@Component
class ElectronicProductPromotionRule(electronicProductForPromotionSpecification: ElectronicProductForPromotionSpecification) :
    PromotionRule(electronicProductForPromotionSpecification, ELECTRONIC_PRODUCT_DISCOUNT)



@Component
class SeniorSellerPromotionRule(seniorSellerForPromotionSpecification: SeniorSellerForPromotionSpecification) :
    PromotionRule(seniorSellerForPromotionSpecification, SENIOR_SELLER_DISCOUNT)

@Component
class JuniorSellerPromotionRule(juniorSellerForPromotionSpecification: JuniorSellerForPromotionSpecification) :
    PromotionRule(juniorSellerForPromotionSpecification, JUNIOR_SELLER_DISCOUNT)


