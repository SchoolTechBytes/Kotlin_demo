# Overview

As a software engineer, I'm always looking to broaden the range of languages I'm comfortable working in. Kotlin stood out to me because it's the primary language for modern Android development and is increasingly used for backend services, so I wanted hands-on experience with its syntax and features before applying it to a larger project.

The software is a small command-line RPG simulation written in Kotlin. It defines a `Character` class (the hero) and an `Enemy` class (a goblin), each with their own stats and behavior, and runs a short battle between them. Along the way the program builds and manages an inventory of items using a mutable collection, letting the player pick up and drop items, and track how many health potions remain. During the battle loop, the hero and enemy trade attacks round by round; the hero can heal using a potion mid-fight, and the program checks after each round whether either side has been defeated. At the end, it reports whether the hero won, leveled up, or was defeated, along with their final inventory and stats.

In writing this program I wanted to demonstrate the core building blocks of the Kotlin language in a single, readable example: mutable and immutable variables (`var` and `val`), expressions, conditionals (`if`/`else`), loops (`for` and `while`), functions, and classes. I also used the program to explore Kotlin's collection types in more depth, specifically creating and modifying a `MutableList` to represent the inventory.

[Software Demo Video](http://youtube.link.goes.here)


# Development Environment

For this software the tools I used were the Kotlin Docs JDK 25 and IntelliJ IDEA 2026.2.3 

# Useful Websites

- [Kotlin Docs](https://kotlinlang.org/docs/getting-started.html)

# Future Work

- Let the player choose actions (attack, heal, flee) each round using keyboard input instead of the battle running automatically.
- Add more enemy types with different stats, and use a `when` expression to vary enemy behavior or attack patterns.
- Convert `Character` into a data class so stats can be easily copied/compared, and add simple equipment items that boost attack or defense.