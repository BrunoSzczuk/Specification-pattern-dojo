package br.com.brunoszczuk.specificationpattern.domain.rule

import br.com.brunoszczuk.specificationpattern.domain.service.RuleToggleService
import br.com.brunoszczuk.specificationpattern.domain.specifications.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


const val ELECTRONIC_PRODUCT_DISCOUNT = 0.05
const val JUNIOR_SELLER_DISCOUNT = 0.05
const val NEW_CLIENT_DISCOUNT = 0.1
const val SENIOR_SELLER_DISCOUNT = 0.15


open class PromotionRule(val specification: PromotionSpecification, val discount: Double) {
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