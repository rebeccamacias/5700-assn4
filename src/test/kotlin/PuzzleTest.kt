import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PuzzleTest {

    @Test
    fun isAndSetSolved() {
        val puzzle = Puzzle
        puzzle.isSolved = true
        assertEquals(true, puzzle.isSolved)
    }

    @Test
    fun getBoard() {
        val puzzle = Puzzle
        val symbols = mutableListOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
        for(i in 0 until 4) {
            val valueList = mutableListOf("4", "3", "2", "1")
            var cellList = mutableListOf<Cell>()
            for (j in 0 until 4) {
                val cell = Cell(valueList[j])
                cell.setPossibleValues(symbols)
                cellList.add(cell)
            }
            puzzle.board.add(i, cellList)
        }
        assertNotNull(puzzle.board)
    }

    @Test
    fun getSetSize() {
        val puzzle = Puzzle
        puzzle.setSize(4)
        assertEquals(4, puzzle.getSize())
    }

    @Test
    fun getValidSymbols() {
        val puzzle = Puzzle
        val symbols = mutableListOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
        puzzle.setValidSymbols(symbols)
        assertEquals(symbols, puzzle.getValidSymbols())
    }

    @Test
    fun checkSingleton() {
        val puzzle = Puzzle
        val newPuzzleMaybe = Puzzle
        assertEquals(puzzle, newPuzzleMaybe)
    }
}