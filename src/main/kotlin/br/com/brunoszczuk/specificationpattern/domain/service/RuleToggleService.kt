package br.com.brunoszczuk.specificationpattern.domain.service

import br.com.brunoszczuk.specificationpattern.domain.repository.RuleToggle
import br.com.brunoszczuk.specificationpattern.domain.repository.RuleToggleRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@Service
class RuleToggleService(private val ruleToggleRepository: RuleToggleRepository) {
    var defaultValue: Boolean = true


    fun isRuleActive(ruleSimpleClassName: String): Boolean {
        val ruleToggle = ruleToggleRepository.findBySimpleClassName(ruleSimpleClassName)
        return ruleToggle?.active ?: defaultValue
    }

    fun changeDefaultValue() {
        defaultValue = !defaultValue
    }

    fun findBySimpleClassName(ruleSimpleClassName: String) = ruleToggleRepository.findBySimpleClassName(ruleSimpleClassName)

    fun findAllByActiveIsTrue() = ruleToggleRepository.findAllByActiveIsTrue()
    fun save(ruleToggle: RuleToggle) = ruleToggleRepository.save(ruleToggle)
    fun findAll(): MutableIterable<RuleToggle> = ruleToggleRepository.findAll()
}

@RestController
@RequestMapping("/api/rules")
class RuleToggleController(private val ruleToggleService: RuleToggleService) {

    @GetMapping
    fun findAllRules(@RequestParam(defaultValue = "false") active: Boolean): Iterable<RuleToggle> = if (active) ruleToggleService.findAllByActiveIsTrue() else ruleToggleService.findAll()

    @PostMapping
    fun toggleRule(@RequestBody ruleSimpleClassName: String): ResponseEntity<RuleToggle> {
        val ruleToggle = ruleToggleService.findBySimpleClassName(ruleSimpleClassName)?.let { it.copy(active = !it.active) } ?: RuleToggle(simpleClassName = ruleSimpleClassName, active = true)
        return ResponseEntity.ok(ruleToggleService.save(ruleToggle))
    }

    @PostMapping("/changeDefaultValue")
    fun changeDefaultValue(): ResponseEntity<Boolean> {
        ruleToggleService.changeDefaultValue()
        return ResponseEntity.ok(ruleToggleService.defaultValue)
    }
}