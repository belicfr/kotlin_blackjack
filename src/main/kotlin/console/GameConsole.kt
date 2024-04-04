package console

import game.Game
import player.Player
import java.util.*

val scanner: Scanner = Scanner(System.`in`)

object GameConsole {
    fun start() {
        println("Welcome to BlackJack game!")

        print("Enter your name: ")
        Game.player.name = scanner.nextLine()

        println("\nLet's start the game, ${Game.player.name}!\n")
    }
}