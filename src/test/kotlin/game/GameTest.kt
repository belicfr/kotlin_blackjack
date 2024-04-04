package game

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GameTest {
    @BeforeEach
    fun setUp() {
        Game.resetPlayers()
    }

    @Test
    fun `Non exceeded game`() {
        Game.player.value = 20
        Game.computer.value = 9

        assertFalse(Game.isExceeded())
    }

    @Test
    fun `Player exceeds game`() {
        Game.player.value = 22
        Game.computer.value = 19

        assertTrue(Game.isExceeded())
    }

    @Test
    fun `Computer exceeds game`() {
        Game.player.value = 10
        Game.computer.value = 24

        assertTrue(Game.isExceeded())
    }

    @Test
    fun `Change current player from PLAYER to COMPUTER`() {
        Game.currentPlayer = Game.player

        Game.changeCurrentPlayer()

        assertEquals(Game.currentPlayer, Game.computer)
    }

    @Test
    fun `Change current player from COMPUTER to PLAYER`() {
        Game.currentPlayer = Game.computer

        Game.changeCurrentPlayer()

        assertEquals(Game.currentPlayer, Game.player)
    }

    @Test
    fun `Player wins game without computer exceeding 21`() {
        Game.player.value = 21
        Game.computer.value = 12

        assertEquals(Game.getWinner(), Game.player)
    }

    @Test
    fun `Computer wins game without player exceeding 21`() {
        Game.computer.value = 21
        Game.player.value = 12

        assertEquals(Game.getWinner(), Game.computer)
    }

    @Test
    fun `Player wins game by computer exceeding 21`() {
        Game.player.value = 12
        Game.computer.value = 22

        assertEquals(Game.getWinner(), Game.player)
    }

    @Test
    fun `Computer wins game by player exceeding 21`() {
        Game.computer.value = 15
        Game.player.value = 23

        assertEquals(Game.getWinner(), Game.computer)
    }
}