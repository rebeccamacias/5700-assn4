package Strategies

import Cell
import Puzzle

class OnlyOnePossibilityStrategy : CellSolutionStrategy(){
    override fun findApplicableCells(puzzle: Puzzle): Pair<List<Cell>, Any> {
        var applicableCells = mutableListOf<Cell>()
        for (row in puzzle.board) {
            for (cell in row) {
                //iterate over each individual cell to update poss values
                if (!cell.isFilled) {

                    //iterate over cells in the same row to update poss values
                    val cellsRow = cell.getRow()
                    for (rowCells in puzzle.board[cellsRow]) {
                        if (rowCells.isFilled) {
                            cell.removeValue(rowCells.symbol)
                        }
                    }

                    //iterate over cells in the same column to update poss values
                    val cellsColumn = cell.getColumn()
                    for (i in 0 until puzzle.board.size) {
                        if (puzzle.board[i][cellsColumn].isFilled) {
                            cell.removeValue(puzzle.board[i][cellsColumn].symbol)
                        }
                    }

                    //iterate over cells in the same box to update poss values
                    val cellsBox = cell.getBoxId()
                    for (i in 0 until puzzle.board.size) {
                        for (j in 0 until puzzle.board.size) {
                            if (puzzle.board[i][j].getBoxId() == cellsBox) {
                                if (puzzle.board[i][j].isFilled) {
                                    cell.removeValue(puzzle.board[i][j].symbol)
                                }
                            }
                        }
                    }
                }
                if (cell.getPossibleValues().size == 1) {
                    applicableCells.add(cell)
                }
            }
        }
        val cellValues = mutableListOf<String>()
        for (cell in applicableCells) {
            cellValues.add(cell.getPossibleValues()[0])
        }
        return applicableCells to cellValues
    }

    override fun applyChanges(puzzle: Puzzle, applicableCells: List<Cell>, manipulationParam: Any): Boolean {
        val cast = manipulationParam as List<String>
        for (i in applicableCells.indices) {
            applicableCells[i].symbol = cast[i]
        }
        return true
    }
}