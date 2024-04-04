package game

import player.Player

val computerName: String = "Computer"

object Game {
    var isGameStarted: Boolean = false
        private set

    var player: Player = Player()
        private set

    var computer: Player = Player(computerName)
        private set

    var currentPlayingPlayer: Player = this.player

    fun start() {
        this.isGameStarted = true

        var drawnCard: Card?

        while (!this.isExceeded()) {
            drawnCard = this.draw()
            println("Drawned card: $drawnCard")
            this.currentPlayingPlayer.value += drawnCard.value
            this.togglePlayingPlayer()
        }
    }

    fun isExceeded(): Boolean
        = this.player.value > 21 || this.computer.value > 21

    fun draw(): Card {
        return Card
            .entries
            .toTypedArray()
            .random()
    }

    fun togglePlayingPlayer() {
        if (this.currentPlayingPlayer == this.player) {
            this.currentPlayingPlayer = this.computer
        } else {
            this.currentPlayingPlayer = this.player
        }
    }

    fun resetPlayers() {
        this.player = Player()
        this.computer = Player(computerName)
    }
}