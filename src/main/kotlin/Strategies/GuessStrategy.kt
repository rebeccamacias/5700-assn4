package Strategies

import Cell
import Puzzle

class GuessStrategy : CellSolutionStrategy() {
    override fun findApplicableCells(puzzle: Puzzle): Pair<List<Cell>, Any> {
        val guessCells = puzzle.board.flatten().filter { it.getPossibleValues().isEmpty() }.sortedBy { it.getPossibleValues().size }
        if (guessCells.isEmpty()) {
            return listOf<Cell>() to Any()
        }
        return listOf(guessCells.first()) to guessCells.first().getPossibleValues()[0]
    }

    override fun applyChanges(puzzle: Puzzle, applicableCells: List<Cell>, manipulationParam: Any): Boolean {
        TODO("not implemented")
//        if (manipulationParam is String) {
//            val cell = applicableCells.first()
//            puzzle.pushCurrentToBacktrackStack(cell, manipulationParam)
//            cell.symbol = manipulationParam
//            return true
//        }

//        return false
    }
}