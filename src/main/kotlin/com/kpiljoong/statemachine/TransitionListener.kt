package com.kpiljoong.statemachine

interface TransitionListener<S : Enum<S>> {
    fun onTransition(from: S, to: S)
}