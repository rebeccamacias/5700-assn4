import java.io.File
import kotlin.io.path.Path
import kotlin.io.path.isDirectory
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val file = File(args[0])
    val lines = file.useLines {
        it.toMutableList()
    }
    val side = lines[0].toInt()
    val validSymbols = lines[1].split(" ") //makes an array of strings containing each valid symbol
    if (sqrt(side.toDouble()) % 1 != 0.0) {
        lines.add("Invalid: not formatted correctly")
        //write new file to output directory with same file name
    }
    var puzzle = Puzzle()
    puzzle.setSize(side)
    puzzle.setValidSymbols(validSymbols)

    for(i in 2 until lines.size) {
        val valueList = lines[i].split(" ").toMutableList() //initial board setup
        if (valueList.size != side) {
            lines.add("Invalid: not formatted correctly")
            //write new file to output directory with same file name
            break
        }
        puzzle.board.add(i - 2, valueList)
    }
//save this code for later - helps test if board is being read right
//    for (i in 0 until side) {
//        for (j in 0 until side) {
//            print(puzzle.board[i][j] + " ")
//        }
//        println()
//    }

//    while(currentPuzzle != null and currentPuzzle not solved and you don't need to backtrack):
//        apply your strategies to the puzzle until one of them makes a change to the puzzle
//        if (no strategies made a change)
//            currentPuzzle = backtrack to the most recent guess // you can use a stack for this and just copy the puzzle at the point a guess is made then just pop it off the stack here
//                    if (no puzzle to backtrack to)
//                        break out of the loop (or let it continue because the loop condition will catch this case because currentPuzzle will be null)
//
//                    else
//                        check to see if the changes solved the puzzle
//    if (puzzle is solved):
//    add the current puzzle to a list of possible solutions
//            currentPuzzle = backtrack to most recent guess
//    if (no puzzle to back track to)
//        done solving
//
//// after the loop
//                if (you have 0 solutions) report accordingly
//                else if (you have exactly 1 solution) report accordingly
//    else report that the puzzle is invalid because it has multiple solutions.
}

fun isPerfectSquare(number: Int): Boolean {
    return sqrt(number.toDouble()) % 1.0 == 0.0
}