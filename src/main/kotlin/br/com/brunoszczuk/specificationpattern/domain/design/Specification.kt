package br.com.brunoszczuk.specificationpattern.domain.design

interface Specification<T> {
    fun isSatisfiedBy(candidate: T): Boolean
    fun and(other: Specification<T>): Specification<T>
    fun or(other: Specification<T>): Specification<T>
    fun not(): Specification<T>
}

