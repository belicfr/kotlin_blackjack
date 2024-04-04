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
}