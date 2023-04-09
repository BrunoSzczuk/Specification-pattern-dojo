package br.com.brunoszczuk.specificationpattern.domain.repository

import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.hibernate.Hibernate
import java.util.UUID

@Entity
data class RuleToggle(
    @Id
    val id: UUID = UUID.randomUUID(),
    val simpleClassName: String,
    val active: Boolean
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as RuleToggle

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}