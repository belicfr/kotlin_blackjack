package game

enum class PlayerAction(val action: Char) {
    DRAW('D'),
    SKIP_TURN('S');

    companion object {
        fun getFromChar(character: Char): PlayerAction? {
            return when (character.uppercaseChar()) {
                'D' -> DRAW
                'S' -> SKIP_TURN
                else -> null
            }
        }
    }
}