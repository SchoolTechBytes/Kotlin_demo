// A beginner Kotlin demo: a simple RPG character with an inventory and a short battle.

class Character(val name: String, var health: Int, var level: Int) {

    val maxHealth: Int = health

    fun takeDamage(amount: Int) {
        health -= amount
        if (health <= 0) {
            health = 0
            println("$name has been defeated!")
        } else {
            println("$name took $amount damage and now has $health HP.")
        }
    }

    fun heal(amount: Int) {
        health += amount
        if (health > maxHealth) {
            health = maxHealth
        }
        println("$name heals for $amount HP and now has $health HP.")
    }

    fun levelUp() {
        level += 1
        println("$name leveled up! Now level $level.")
    }

    fun isAlive(): Boolean = health > 0

    fun describe(): String = "$name (Level $level, $health/$maxHealth HP)"
}

class Enemy(val name: String, var health: Int, val attackPower: Int) {

    fun isAlive(): Boolean = health > 0

    fun describe(): String = "$name ($health HP, attacks for $attackPower)"
}

fun levelUpMessage(level: Int): String {
    return "Starting at level $level. Stats are growing stronger."
}

fun printInventory(items: List<String>) {
    println("Inventory:")
    for (item in items) {
        println(" - $item")
    }
}

fun countPotions(items: List<String>): Int {
    var count = 0
    for (item in items) {
        if (item.contains("Potion")) {
            count++
        }
    }
    return count
}

fun main() {
    // Variables: val is immutable, var is mutable.
    val heroName = "Rowan"
    var startingHealth = 100
    val startingLevel = 1

    startingHealth += 20 // reassigning a var

    val hero = Character(heroName, startingHealth, startingLevel)
    println(hero.describe())
    println(levelUpMessage(hero.level))

    // Collections: a mutable list we create and then modify.
    val inventory = mutableListOf("Wooden Sword", "Leather Shield", "Health Potion")
    printInventory(inventory)

    inventory.add("Magic Scroll")
    inventory.add("Health Potion")
    inventory.remove("Wooden Sword")
    println("\nAfter picking up some items and dropping the old sword:")
    printInventory(inventory)

    val potionCount = countPotions(inventory)
    println("Potions remaining: $potionCount")

    // Set up an enemy for the battle.
    val goblin = Enemy("Goblin", 60, 15)
    println("\nA wild ${goblin.describe()} appears!")

    // Loop: trade attacks each round until one side falls or the hero heals.
    var round = 1
    while (hero.isAlive() && goblin.isAlive() && round <= 6) {
        println("\n-- Round $round --")

        goblin.health -= 20
        if (goblin.isAlive()) {
            println("${hero.name} strikes the ${goblin.name} for 20 damage. ${goblin.health} HP left.")
        } else {
            println("${hero.name} defeats the ${goblin.name}!")
            break
        }

        hero.takeDamage(goblin.attackPower)

        // Use a potion to heal partway through the fight if one is available.
        if (round == 3 && potionCount > 0 && hero.isAlive()) {
            inventory.remove("Health Potion")
            hero.heal(30)
        }

        round++
    }

    // Conditional: check the final outcome and reward the hero if they won.
    if (hero.isAlive() && !goblin.isAlive()) {
        hero.levelUp()
        println("\n${hero.name} survived with ${hero.health} HP remaining!")
    } else if (!hero.isAlive()) {
        println("\n${hero.name} did not make it out of the battle.")
    } else {
        println("\nThe battle ended before either side was defeated.")
    }

    println("\nFinal inventory:")
    printInventory(inventory)
    println("Final status: ${hero.describe()}")
}
