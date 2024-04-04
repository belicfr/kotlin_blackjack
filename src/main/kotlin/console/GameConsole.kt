package console

import game.Game
import game.PlayerAction
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

    fun askAction(): PlayerAction {
        val defaultAction: PlayerAction = PlayerAction.SKIP_TURN
        var action: String = ""

        println("It's your turn, ${Game.player.name}!\n")

        while (action.isBlank()) {
            println("Type: [D]raw | [S]kip turn")
            action = scanner.nextLine()

            if (action.isNotBlank() && this.isValidAction(action[0])) {
                return PlayerAction.getFromChar(action[0])
                    ?: defaultAction
            } else {
                action = ""
            }
        }

        return defaultAction
    }

    fun isValidAction(action: Char)
        = action.equals('D') || action.equals('S')
}