package com.kpiljoong.statemachine

import kotlin.collections.forEach

class StateMachine<S : Enum<S>>(
    private val transitions: Set<Transition<S>>,
    private val listeners: List<TransitionListener<S>> = emptyList()
) {
    val validTransitions: Set<Transition<S>> get() = transitions

    fun canTransition(from: S, to: S): Boolean =
        transitions.any { it.from == from && it.to == to && (it.guard?.invoke() ?: true) }

    fun transition(current: S, to: S): S {
        if (!canTransition(current, to)) {
            throw IllegalStateException("Invalid transition from $current to $to")
        }
        listeners.forEach { it.onTransition(current, to) }
        return to
    }

    fun nextStates(from: S): Set<S> = transitions
        .filter { it.from == from && (it.guard?.invoke() ?: true) }
        .map { it.to }
        .toSet()
}