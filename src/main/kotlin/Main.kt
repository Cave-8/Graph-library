import java.lang.Integer.parseInt
import java.util.concurrent.TimeoutException
import kotlin.system.exitProcess

/**
 * Main function
 */
fun main() {
    println("Welcome to graph lib!")

    while (true) {
        println("Available options: ")
        println("1: Print graph")
        println("2: Delete graph")
        println("3: Search value in graph")
        println("4: Exit")

        do {
            val choice: Int = Integer.valueOf(readln())

            when (choice) {
                1 -> {

                }
                2 -> {

                }
                3 -> {

                }
                4 -> {
                    println("Goodbye!")
                    exitProcess(0)
                }
                else -> println("Choose an available option!")
            }
        } while ((choice != 1) && (choice != 2) && (choice != 3) && (choice != 4))
    }
}