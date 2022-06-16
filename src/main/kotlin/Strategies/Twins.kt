package Strategies

import Cell
import Puzzle

class Twins : CellSolutionStrategy() {
    override fun findApplicableCells(puzzle: Puzzle): Pair<List<Cell>, Any> {
        TODO("Not yet implemented. This would've found cells with twins")
    }

    override fun applyChanges(puzzle: Puzzle, cells: List<Cell>, manipulationParam: Any): Boolean {
        TODO("Not yet implemented. This would've applied the changes")
    }
}