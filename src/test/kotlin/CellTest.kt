import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CellTest {

    @Test
    fun isFilled() {
        val cell = Cell("1")
        assertTrue(cell.isFilled)
        val cell2 = Cell("-")
        assertFalse(cell2.isFilled)
    }

    @Test
    fun getSetPossibleValues() {
        val cell = Cell("1")
        cell.setPossibleValues(listOf("2", "3"))
        assertEquals(listOf("2", "3"), cell.getPossibleValues())
    }

    @Test
    fun removeValue() {
        val cell = Cell("1")
        cell.setPossibleValues(listOf("2", "3"))
        cell.removeValue("2")
        assertEquals(listOf("3"), cell.getPossibleValues())
    }

    @Test
    fun clearPossibleValues() {
        val cell = Cell("1")
        cell.setPossibleValues(listOf("2", "3"))
        cell.clearPossibleValues()
        assertEquals(emptyList<String>(), cell.getPossibleValues())
    }

    @Test
    fun getSetRow() {
        val cell = Cell("1")
        cell.setRow(4)
        assertEquals(4, cell.getRow())
    }

    @Test
    fun getColumn() {
        val cell = Cell("1")
        cell.setColumn(4)
        assertEquals(4, cell.getColumn())
    }

    @Test
    fun getBoxId() {
        val cell = Cell("1")
        cell.setBoxId(4)
        assertEquals(4, cell.getBoxId())
    }


}