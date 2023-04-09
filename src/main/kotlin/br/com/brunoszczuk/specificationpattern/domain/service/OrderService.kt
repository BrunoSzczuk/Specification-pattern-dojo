package br.com.brunoszczuk.specificationpattern.domain.service

import br.com.brunoszczuk.specificationpattern.domain.Order
import br.com.brunoszczuk.specificationpattern.domain.rule.PromotionRule
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Service
class OrderService(val promotionRules: List<PromotionRule>) {
    fun insert(order: Order): Pair<String?, Double> {
        val ruleAccepted = promotionRules
            .filter { it.specification.isSatisfiedBy(order) && it.active }
            .maxByOrNull { it.discount }

        return ruleAccepted?.let { it.javaClass.simpleName to it.discount } ?: (null to 0.0)
    }
}

@RestController
@RequestMapping("/api/orders")
class OrderController(val orderService: OrderService) {
    @PostMapping
    fun insert(@RequestBody order: Order): ResponseEntity<Pair<String?, Double>> {
        return ResponseEntity.ok(orderService.insert(order))
    }
}