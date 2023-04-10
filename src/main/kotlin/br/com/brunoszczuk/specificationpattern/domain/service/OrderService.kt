package br.com.brunoszczuk.specificationpattern.domain.service

import br.com.brunoszczuk.specificationpattern.domain.Order
import br.com.brunoszczuk.specificationpattern.domain.rule.PromotionRule
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@Service
class OrderService(val promotionRules: List<PromotionRule>) {
    fun insert(order: Order): OrderResponse {
        val rulesAccepted = promotionRules
            .filter { it.specification.isSatisfiedBy(order) && it.active }

        return OrderResponse(
            rulesAccepted
                .map { it.javaClass.simpleName to it.discount }
                .toMutableList(),
            rulesAccepted.sumOf { it.discount }
        )
    }
}

@RestController
@RequestMapping("/api/orders")
class OrderController(val orderService: OrderService) {
    @PostMapping
    fun insert(@RequestBody order: Order): ResponseEntity<OrderResponse> {
        return ResponseEntity.ok(orderService.insert(order))
    }
}

data class OrderResponse(val rules : List<Pair<String?, BigDecimal>>, val totalDiscount: BigDecimal)