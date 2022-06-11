class Cell {
    private val possibleNumbers: MutableList<Int> = mutableListOf()
    fun getPossibleNumbers(): List<Int> = possibleNumbers
    private fun removeNumber(number: Int) {
        possibleNumbers.remove(number)
    }
}