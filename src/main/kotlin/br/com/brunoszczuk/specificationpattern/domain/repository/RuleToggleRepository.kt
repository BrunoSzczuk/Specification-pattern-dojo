package br.com.brunoszczuk.specificationpattern.domain.repository

import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface RuleToggleRepository : CrudRepository<RuleToggle, UUID> {
    fun findBySimpleClassName(simpleClassName: String): RuleToggle?
    fun findAllByActiveIsTrue(): List<RuleToggle>
}