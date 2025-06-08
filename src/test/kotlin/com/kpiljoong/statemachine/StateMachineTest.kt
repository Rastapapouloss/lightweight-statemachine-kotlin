package com.kpiljoong.statemachine

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

enum class TestStatus { INIT, STEP1, STEP2, DONE }

class StateMachineTest {
    @Test
    fun `valid transition works`() {
        val sm = StateMachine(setOf(Transition(TestStatus.INIT, TestStatus.STEP1)))
        val result = sm.transition(TestStatus.INIT, TestStatus.STEP1)
        assertEquals(TestStatus.STEP1, result)
    }

    @Test
    fun `invalid transition throws`() {
        val sm = StateMachine(setOf(Transition(TestStatus.INIT, TestStatus.STEP1)))
        assertThrows(IllegalStateException::class.java) {
            sm.transition(TestStatus.STEP1, TestStatus.DONE)
        }
    }

    @Test
    fun `guard blocks transition`() {
        val sm = StateMachine(setOf(Transition(TestStatus.STEP1, TestStatus.DONE) { false }))
        assertFalse(sm.canTransition(TestStatus.STEP1, TestStatus.DONE))
    }

    @Test
    fun `listener is triggered`() {
        var called = false
        val listener = object : TransitionListener<TestStatus> {
            override fun onTransition(from: TestStatus, to: TestStatus) {
                called = true
            }
        }
        val sm = StateMachine(
            setOf(Transition(TestStatus.INIT, TestStatus.STEP1)),
            listOf(listener)
        )
        sm.transition(TestStatus.INIT, TestStatus.STEP1)
        assertTrue(called)
    }
}