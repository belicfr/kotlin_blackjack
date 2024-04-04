package game

import console.GameConsole
import player.Player

val computerName: String = "Computer"

object Game {
    var isGameStarted: Boolean = false
        private set

    var player: Player = Player()
        private set

    var computer: Player = Player(computerName)
        private set

    var currentPlayer: Player = this.player

    fun start() {
        this.isGameStarted = true

        var drawnCard: Card?

        while (!this.isGameEnded()) {
            if (this.currentPlayer == this.player) {
                this.askAction()
                println("${this.player.name} [${this.player.value} pts]\n")
            } else {
                this.draw()
                println("${this.computer.name} [${this.computer.value} pts]\n")
            }

            this.changeCurrentPlayer()
        }

        println("GAME ENDED!")
        println("Winner: ${this.getWinner()?.name}")
    }

    fun askAction() {
        var playerAction: PlayerAction = GameConsole.askAction()

        if (playerAction == PlayerAction.DRAW) {
            var drownCard: Card = this.draw()
            println("You drown ${drownCard.name} [+${drownCard.value}]\n")
        }
    }

    fun isExceeded(): Boolean
        = this.player.value > 21 || this.computer.value > 21

    fun isGameEnded(): Boolean
        = this.isExceeded() || this.player.value == 21 || this.computer.value == 21

    fun getWinner(): Player? {
        var winner: Player? = null

        if (this.isGameEnded()) {
            if (this.player.value == 21 || this.computer.value > 21) {
                winner = this.player
            } else if (this.computer.value == 21 || this.player.value > 21) {
                winner = this.computer
            }
        }

        return winner
    }

    fun draw(): Card {
        val drownCard: Card = Card
            .entries
            .toTypedArray()
            .random()

        this.currentPlayer.value += drownCard.value

        return drownCard
    }

    fun changeCurrentPlayer() {
        if (this.currentPlayer == this.player) {
            this.currentPlayer = this.computer
        } else {
            this.currentPlayer = this.player
        }
    }

    fun resetPlayers() {
        this.player = Player()
        this.computer = Player(computerName)
    }
}