import Strategies.GuessStrategy
import Strategies.OnlyOnePlaceStrategy
import Strategies.OnlyOnePossibilityStrategy
import java.io.File
import java.util.*
import kotlin.io.path.Path
import kotlin.io.path.isDirectory
import kotlin.math.sqrt
var puzzleCopies : Stack<Puzzle> = Stack()
var solutions: MutableList<Puzzle> = mutableListOf()
var currentPuzzle: Puzzle? = null
fun main(args: Array<String>) {
    val file = File(args[0])
    val lines = file.useLines {
        it.toMutableList()
    }
    val side = lines[0].toInt()
    val validSymbols = lines[1].split(" ") //makes an array of strings containing each valid symbol
    if (sqrt(side.toDouble()) % 1 != 0.0) {
        lines.add("Invalid: size of puzzle is not a perfect square")
        //write new file to output directory with same file name
    }
    val currentPuzzle = Puzzle
    currentPuzzle.setSize(side)
    currentPuzzle.setValidSymbols(validSymbols)

    var boxCounter = 1
    var rowCounter = 1
    var columnCounter = 1

    for(i in 2 until lines.size) {
        val valueList = lines[i].split(" ").toMutableList() //initial board setup
        if (valueList.size != side) {
            lines.add("Invalid: not formatted correctly")
            //write new file to output directory with same file name
            break
        }
        var cellList = mutableListOf<Cell>()
        for (j in 0 until side) {
            if (valueList[j] !in validSymbols && valueList[j] != "-") {
                lines.add("Invalid: invalid symbol detected")
                //write new file to output directory with same file name
                break
            }
            val cell = Cell(valueList[j])
            cell.setRow(i - 2)
            cell.setColumn(j)
            if (columnCounter > sqrt(side.toDouble())) {
                columnCounter = 1
                boxCounter++
            }
            cell.setPossibleValues(validSymbols)
            if (cell.isFilled) {
                cell.clearPossibleValues()
            }
            cell.setBoxId(boxCounter)
            cellList.add(cell)
            columnCounter++
        }
        columnCounter = 1
        rowCounter++
        boxCounter -= (sqrt(side.toDouble()).toInt() - 1)
        if (rowCounter > sqrt(side.toDouble())) {
            rowCounter = 1
            boxCounter += (sqrt(side.toDouble()).toInt())
        }
        currentPuzzle.board.add(i - 2, cellList)
    }
    puzzleCopies.push(currentPuzzle)
    solve(currentPuzzle, side)
}
fun solve(puzzleRN: Puzzle, side: Int) {
    val strategies = listOf(
        OnlyOnePossibilityStrategy(),
        OnlyOnePlaceStrategy(),
        GuessStrategy(),
    )

    while(solutions.size < 2) {
        val changeMade = strategies.any { it.execute(puzzleRN)}
        var doBacktrack = false
        var someUnfilled = false
        for (row in puzzleRN.board) {
            for (cell in row) {
                if (!cell.isFilled) {
                    someUnfilled = true
                }
            }
        }
        if (someUnfilled) {
            puzzleRN.isSolved = true
        }
        if (puzzleRN.isSolved) {
            solutions.add(puzzleRN)
            doBacktrack = true
        }
        if (!changeMade) {
            doBacktrack = true
        }
        if (doBacktrack) {
            if (puzzleCopies.isEmpty()) {
                break
            }
            currentPuzzle = puzzleCopies.pop()
        }
    }
    if (solutions.size == 0) {
        println("There are no solutions for this puzzle")
    }
    for (solution in solutions) {
        for (i in 1 until  side+ 1) {
            for (j in 1 until side + 1) {
                print(solution.board[i - 1][j - 1].toString() + " ")
                if (j % sqrt(side.toDouble()) == 0.0 && j != 0) {
                    print("| ")
                }
            }
            println()
            if (i % sqrt(side.toDouble()) == 0.0 && i != 0) {
                println("--".repeat(side + 1))
            }
        }
    }
}
