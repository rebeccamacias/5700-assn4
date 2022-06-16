package Strategies

import Cell
import Puzzle

class OnlyOnePlaceStrategy: CellSolutionStrategy() {
    override fun findApplicableCells(puzzle: Puzzle): Pair<List<Cell>, Any> {
        TODO("Not yet implemented. Based on the boxes, rows, and columns, and characters, " +
                "this would find the cells with only one place a character could possibly go")
    }

    override fun applyChanges(puzzle: Puzzle, applicableCells: List<Cell>, manipulationParam: Any): Boolean {
        TODO("Not yet implemented. This would apply the changes to the puzzle")
    }
}