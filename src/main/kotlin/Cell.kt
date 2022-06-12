class Cell(var symbol: String) {
    private val possibleValues: MutableList<String> = mutableListOf()
    val isFilled = symbol != "-"

    fun getPossibleValues(): List<String> = possibleValues
    fun setPossibleValues(values: List<String>) {
        possibleValues.clear()
        possibleValues.addAll(values)
    }
    override fun toString() : String {
        return symbol
    }
    //do we really need this to return a boolean?
    private fun removeValue(value: String) : Boolean {
        if (possibleValues.contains(value)) {
            possibleValues.remove(value)
        }
        return true
    }
}