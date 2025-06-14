# Lightweight State Machine for Kotlin 🚀

![Kotlin](https://img.shields.io/badge/Kotlin-7F52B3?style=flat-square&logo=kotlin&logoColor=white) ![GitHub Release](https://img.shields.io/github/release/Rastapapouloss/lightweight-statemachine-kotlin.svg?style=flat-square) ![License](https://img.shields.io/badge/License-MIT-blue.svg?style=flat-square)

Welcome to the **Lightweight State Machine for Kotlin**! This library provides a simple and efficient way to implement state machines in your Kotlin applications. With guard support, listeners, and the ability to export to DOT graphs, it integrates seamlessly into domain-driven design systems.

## Table of Contents

- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Example](#example)
- [Exporting to DOT](#exporting-to-dot)
- [Listeners](#listeners)
- [Contributing](#contributing)
- [License](#license)
- [Links](#links)

## Features

- **Lightweight**: Designed for simplicity and ease of use.
- **Guard Support**: Control state transitions based on conditions.
- **Listeners**: Monitor state changes and react accordingly.
- **DOT Graph Export**: Visualize your state machine using Graphviz.
- **Integration Ready**: Works well with domain-driven design principles.

## Installation

To add the library to your project, include the following dependency in your `build.gradle` file:

```groovy
dependencies {
    implementation 'com.example:lightweight-statemachine-kotlin:1.0.0'
}
```

Make sure to replace `1.0.0` with the latest version available. You can find the latest releases [here](https://github.com/Rastapapouloss/lightweight-statemachine-kotlin/releases).

## Usage

Using the state machine is straightforward. First, define your states and transitions. Then, create a state machine instance and start it. Here’s a simple example:

```kotlin
val stateMachine = StateMachine {
    state("idle") {
        onEntry { println("Entering idle state") }
        transition("start", "running")
    }
    state("running") {
        onEntry { println("Entering running state") }
        transition("stop", "idle")
    }
}

stateMachine.start()
stateMachine.trigger("start")
stateMachine.trigger("stop")
```

This example demonstrates a basic state machine with two states: `idle` and `running`. The state machine starts in the `idle` state and transitions to `running` when triggered.

## Example

For a more detailed example, check out the `examples` directory in the repository. You will find various use cases demonstrating how to implement different state machines tailored to specific needs.

## Exporting to DOT

The library supports exporting the state machine to a DOT format. This allows you to visualize your state machine using Graphviz. Here’s how to do it:

```kotlin
val dotFormat = stateMachine.exportToDot()
println(dotFormat)
```

This will output a DOT representation of your state machine, which you can then use to generate graphs.

## Listeners

Listeners allow you to react to state changes. You can add listeners to the state machine to perform actions when entering or exiting states. Here’s an example:

```kotlin
stateMachine.addListener(object : StateMachineListener {
    override fun onStateChange(newState: String) {
        println("State changed to: $newState")
    }
})
```

This listener will print the new state every time the state machine transitions.

## Contributing

We welcome contributions! If you would like to help improve the library, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes.
4. Write tests for your changes.
5. Submit a pull request.

Please ensure that your code adheres to the existing style and includes relevant documentation.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Links

For more information and to download the latest version, visit the [Releases](https://github.com/Rastapapouloss/lightweight-statemachine-kotlin/releases) section. 

Feel free to reach out with any questions or suggestions. Happy coding!