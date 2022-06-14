class Cell(var symbol: String) {
    private val possibleValues: MutableList<String> = mutableListOf()
    private var row = 0
    private var column = 0
    private var boxId = 0
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

    fun setRow(row: Int) {
        this.row = row
    }

    fun setColumn(column: Int) {
        this.column = column
    }

    fun getRow() : Int {
        return row
    }

    fun getColumn() : Int {
        return column
    }

    fun getBoxId() : Int {
        return boxId
    }

    fun setBoxId(boxId: Int) {
        this.boxId = boxId
    }
}