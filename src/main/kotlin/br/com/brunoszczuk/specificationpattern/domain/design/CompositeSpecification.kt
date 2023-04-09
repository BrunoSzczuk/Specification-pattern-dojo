package br.com.brunoszczuk.specificationpattern.domain.design

abstract class CompositeSpecification<T> : Specification<T> {
    override fun and(other: Specification<T>): Specification<T> {
        return AndSpecification(this, other)
    }

    override fun or(other: Specification<T>): Specification<T> {
        return OrSpecification(this, other)
    }

    override fun not(): Specification<T> {
        return NotSpecification(this)
    }
}

class AndSpecification<T>(private val spec1: Specification<T>, private val spec2: Specification<T>) : CompositeSpecification<T>() {
    override fun isSatisfiedBy(candidate: T): Boolean {
        return spec1.isSatisfiedBy(candidate) && spec2.isSatisfiedBy(candidate)
    }
}

class NotSpecification<T>(private val spec: Specification<T>) : CompositeSpecification<T>() {
    override fun isSatisfiedBy(candidate: T): Boolean {
        return !spec.isSatisfiedBy(candidate)
    }
}

class OrSpecification<T>(private val spec1: Specification<T>, private val spec2: Specification<T>) : CompositeSpecification<T>() {
    override fun isSatisfiedBy(candidate: T): Boolean {
        return spec1.isSatisfiedBy(candidate) || spec2.isSatisfiedBy(candidate)
    }
}