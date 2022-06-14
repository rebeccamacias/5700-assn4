import java.io.File
import java.util.*
import kotlin.io.path.Path
import kotlin.io.path.isDirectory
import kotlin.math.sqrt
var puzzleCopies : Stack<Puzzle> = Stack()
var possibleSolutions: MutableList<Puzzle> = mutableListOf()
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
    var currentPuzzle = Puzzle
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
            cell.setPossibleValues(validSymbols)
            cell.setRow(i - 2)
            cell.setColumn(j)
            if (columnCounter > sqrt(side.toDouble())) {
                columnCounter = 1
                boxCounter++
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
//save this code for later - helps test if board is being read right
//    for (i in 1 until side + 1) {
//        for (j in 1 until side + 1) {
//            print(currentPuzzle.board[i - 1][j - 1].toString() + " ")
//            if (j % sqrt(side.toDouble()) == 0.0 && j != 0) {
//                print("| ")
//            }
//        }
//        println()
//        if (i % sqrt(side.toDouble()) == 0.0 && i != 0) {
//            println("--".repeat(side + 1))
//        }
//    }

//    currentPuzzle = puzzleCopies.pop()
////    while(currentPuzzle != null and currentPuzzle not solved and you don't need to backtrack):
//    while (currentPuzzle != null && !currentPuzzle.isSolved) {
//        //apply your strategies to the puzzle until one of them makes a change to the puzzle
//
//    }
////        if (no strategies made a change)
//            currentPuzzle = puzzleCopies.pop() //currentPuzzle = backtrack to the most recent guess // you can use a stack for this and just copy the puzzle at the point a guess is made then just pop it off the stack here
//                    if (puzzleCopies.isEmpty()) //if (no puzzle to backtrack to)
//                        break//break out of the loop (or let it continue because the loop condition will catch this case because currentPuzzle will be null)
//                    else
//                        //check to see if the changes solved the puzzle
//                        if (currentPuzzle.isSolved) { //    if (puzzle is solved):
//                            possibleSolutions.add(currentPuzzle) //add the current puzzle to a list of possible solutions
//                        }
//            currentPuzzle = puzzleCopies.pop() //backtrack to the most recent guess
//        if (puzzleCopies.isEmpty()) {//if (no puzzle to back track to)
//            break//currentPuzzle.isSolved = true//done solving ?????
////// after the loop
//                    if (possibleSolutions.size == 0) {//if (you have 0 solutions)
////                        report accordingly
//                    } else if (possibleSolutions.size == 1) {//if (you have exactly 1 solution)
////                        report accordingly
//                    } else {
//                        //report puzzle is invalid bc it has multiple soln's
//                    }
}