# Lightweight State Machine (Kotlin)

A lightweight and extensible state machine library for Kotlin with support for guarded transitions, transition listeners, and DOT graph export for visualization.

## Features

- Type-safe transitions using enums
- Optional guards (`() -> Boolean`)
- Transition listeners for side effects
- DOT graph export for Graphviz
- Minimal dependency footprint

## Usage

### 1. Define States

```kotlin
enum class TestStatus {
  INIT, STEP1, STEP2, DONE
}
```

### 2. Create State Machine

```kotlin
val testStateMachine = StateMachine(
    transitions = setOf(
        Transition(INIT,  STEP1),
        Transition(STEP1, STEP2),
        Transition(STEP2, DONE, guard = { true }) // Optional guard
    ),
    listeners = listOf(object : TransitionListener<TestStatus> {
        override fun onTransition(from: TestStatus, to: TestStatus) {
            println("Transitioned from $from to $to")
        }
    })
)
```

### 3. Transition States

```kotlin
val next = testStateMachine.transition(TestStatus.INIT, TestStatus.STEP1)
```

## Install via JitPack

Add to your `build.gradle.kts`:

```kotlin
repositories {
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation("com.github.kpiljoong:lightweight-statemachine-kotlin:1.0.2")
}
```

## Export Graph

Use this in a Gradle task:

```kotlin
val dot = testStateMachine.toDotGraph("TestStatus")
File("build/test_status.dot").writeText(dot)
```

## Test

```bash
./gradlew test
```

## License

MIT
