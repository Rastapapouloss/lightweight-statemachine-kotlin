package com.kpiljoong.statemachine

fun <S : Enum<S>> StateMachine<S>.toDotGraph(graphName: String = "StateMachine"): String {
    return buildString {
        appendLine("digraph $graphName {")
        validTransitions.forEach {
            appendLine("  ${it.from.name} -> ${it.to.name};")
        }
        appendLine("}")
    }
}