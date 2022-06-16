package Strategies

import Cell
import Puzzle

class OnlyOnePlaceStrategy: CellSolutionStrategy() {
    override fun findApplicableCells(puzzle: Puzzle): Pair<List<Cell>, Any> {
        TODO("Not yet implemented")
    }

    override fun applyChanges(puzzle: Puzzle, applicableCells: List<Cell>, manipulationParam: Any): Boolean {
        TODO("Not yet implemented")
    }
}