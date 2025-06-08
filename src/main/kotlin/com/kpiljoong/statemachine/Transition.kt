package com.kpiljoong.statemachine

data class Transition<S : Enum<S>>(
    val from: S,
    val to: S,
    val guard: (() -> Boolean)? = null
) {
    override fun equals(other: Any?): Boolean =
        other is Transition<*> && from == other.from && to == other.to

    override fun hashCode(): Int = from.hashCode() * 31 + to.hashCode()
}